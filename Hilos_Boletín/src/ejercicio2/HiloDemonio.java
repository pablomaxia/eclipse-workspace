package ejercicio2;

public class HiloDemonio extends Thread {
	private int inicio;

	public HiloDemonio(String nombre, int prioridad, boolean daemon, int inicio) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(daemon);
		this.inicio = inicio;
		start();
	}

	public static void main(String[] args) {
		HiloDemonio hilo1 = new HiloDemonio("DEMONIO", MIN_PRIORITY, true, 16);
		HiloDemonio hilo2 = new HiloDemonio("HILO", 2, false, 3);
	}

	public void run() {
		int i = this.inicio;
		int tope = 10;
		String texto = "";
		System.out.printf("Dentro del hilo: %s, Prioridad: %d, ID: %d\n", this.getName(), this.getPriority(),
				this.getId());

		hiloEjecutandose();

		if (isDaemon()) {
			texto = "del demonio";
		} else {
			texto = "de la aplicación";

		}

		while (i != tope) {
			if (i > tope) {
				System.out.println(getName() + ": Esto no se para nunca!!!");
			}
			System.out.println(getName() + ": " + i);
		}

		try {
			sleep(1000);
		} catch (InterruptedException e) {
			
		}
		i++;
		if (interrupted()) {
			System.out.println("El hilo fue interrumpido");
		}
		System.out.printf("Se sale del Hilo: %s\n", this.getName());
	}

	public void hiloEjecutandose() {
		System.out.printf("En este momento la CPU ejecuta: %s\n", currentThread().getName());
	}

}
