package ejercicio1;

public class Hilo  extends Thread {

	public void run() {
		System.out.printf("Dentro del hilo: %s, Prioridad: %d, ID: %d\n", this.getName(), this.getPriority(),
				this.getId());

		hiloEjecutandose();
		try {
			sleep(1000);
		} catch (InterruptedException e) {

		}
		if (interrupted()) {
			System.out.println("El hilo fue interrumpido");
		}
		System.out.printf("Se sale del Hilo: %s\n", this.getName());
	}

	public static void main(String args[]) {
		Hilo hilos[] = new Hilo[3];
		for (int i = 0; i < hilos.length; i++) {
			hilos[i] = new Hilo();
			hilos[i].setName("HILO" + i);
			hilos[0].setPriority(1);
			hilos[i].setPriority(i + 2);
			hilos[i].start();
			System.out.printf("Información del %s: %s\n", hilos[i].getName(), hilos[i].toString());
		}

		System.out.println(hilos.length + " HILOS CREADOS...");
		try {
			// retardo 2 segundos
			sleep(2000);
		} catch (InterruptedException e) {

		}

		for (int i = 0; i < hilos.length; i++) {
			if (hilos[i].isAlive()) {
				System.out.printf("El hilo %s se está ejecutando.\n", hilos[i].getName());
				hilos[i].interrupt();
				System.out.printf("El hilo %s se ha interrumpido.\n", hilos[i].getName());
			} else {
				System.out.printf("El hilo %s ha finalizado.\n", hilos[i].getName());
			}

		}

		System.out.println("Fin de la ejecución del proceso padre.");
	}

	public void hiloEjecutandose() {
		System.out.printf("En este momento la CPU ejecuta: %s\n", currentThread().getName());
	}
}