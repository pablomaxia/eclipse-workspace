package ejercicio05_interrumpir_varios_hilos;

import java.awt.Component;

public class PelotaHilos implements Runnable{
   private Pelota  pelota;
   private Component componente;

   @Override
    public void run() {
	   System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
	   //for (int i=1; i<=3000; i++){
		
	   //while(!Thread.interrupted()) {	
	   
	   while(!Thread.currentThread().isInterrupted()) {	
			pelota.mueve_pelota(componente.getBounds());
			
			componente.paint(componente.getGraphics());
			
			//cd interrumpamos el hilo salta InterruptesException
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				//System.out.println("el hilo ha sido interrumpido.");
				Thread.currentThread().interrupt(); //solo interrumpimos el último
			}
		}
	   System.out.println("Estado del hilo al finalizar: " + Thread.currentThread().isInterrupted());
     }

    public PelotaHilos(Pelota pelota, Component componente) {
     super();
	 this.pelota = pelota;
	 this.componente = componente;
   }
   
   
}
