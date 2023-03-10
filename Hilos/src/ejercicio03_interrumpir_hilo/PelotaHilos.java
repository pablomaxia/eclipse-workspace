package ejercicio03_interrumpir_hilo;

import java.awt.Component;

public class PelotaHilos implements Runnable {
	Pelota pelota;
	Component componente;

	@Override
	public void run() {
		System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
		while (!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(componente.getBounds());

			componente.paint(componente.getGraphics());

			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
	}

	public PelotaHilos(Pelota pelota, Component componente) {
		super();
		this.pelota = pelota;
		this.componente = componente;
	}

}
