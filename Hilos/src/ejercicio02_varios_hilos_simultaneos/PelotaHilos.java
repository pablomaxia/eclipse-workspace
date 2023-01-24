package ejercicio02_varios_hilos_simultaneos;

import java.awt.Component;

public class PelotaHilos implements Runnable{
	Pelota pelota;
	Component componente;

	@Override
	public void run() {
		for (int i = 1; i <= 3000; i++) {

			pelota.mueve_pelota(componente.getBounds());

			componente.paint(componente.getGraphics());

			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public PelotaHilos(Pelota pelota, Component componente) {
		super();
		this.pelota = pelota;
		this.componente = componente;
	}

}
