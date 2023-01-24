package ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Hilo extends Thread {

	public Hilo(String nombre, int prioridad, boolean daemon) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(daemon);
		start();
	}

	public static void main(String[] args) {
		Hilo hilo1 = new Hilo("HILO1", MAX_PRIORITY, false);
		Hilo hilo2 = new Hilo("HILO2", 7, false);
		Hilo hilo3 = new Hilo("HILO3", 6, true);
	}

	public void run() {
		System.out.printf("Dentro del hilo: %s, Prioridad: %d, ID: %d\n", this.getName(), this.getPriority(),
				this.getId());

		hiloEjecutandose();
		try {
			sleep(1000);
		} catch (InterruptedException e) {

		}
		try {
			File file = new File(getName() + ".txt");
			FileWriter myWriter = new FileWriter(file.getName());

			System.out.println("Archivo creado: " + file.getName());
			for (int i = 0; i <= 10000; i++) {
				myWriter.write(String.valueOf(i) + "\n");
			}
		     myWriter.close();
			System.out.println("Fin de la creación del fichero: " + getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (interrupted()) {
			System.out.println("El hilo fue interrumpido");
		}
		System.out.printf("Se sale del Hilo: %s\n", this.getName());
	}

	public void hiloEjecutandose() {
		System.out.printf("En este momento la CPU ejecuta: %s\n", currentThread().getName());
	}

}
