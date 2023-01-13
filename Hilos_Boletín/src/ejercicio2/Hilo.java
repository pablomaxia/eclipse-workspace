package ejercicio2;

import java.util.Scanner;

public class Hilo extends Thread {
	public Hilo(String nombre, int prioridad) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(false);
		start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(1000); // 1 segundo (se mide en milisegundos)
			} catch (InterruptedException e) {
				e.getMessage();
			}
			if (interrupted()) {
				System.out.println("El hilo fue interrumpido");
			}
			System.out.printf("Se sale del Hilo: %s\n", this.getName());
			System.out.println("Tarea finalizada");

		}
	}
}
