package base;

public class Hilo extends Thread {

	public Hilo(String nombre, int prioridad, boolean daemon) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(daemon);
		start();
	}

	public static void main(String[] args) {
	}

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

	public void hiloEjecutandose() {
		System.out.printf("En este momento la CPU ejecuta: %s\n", currentThread().getName());
	}

}
