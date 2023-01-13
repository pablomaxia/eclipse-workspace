package hilo;

public class Hilo0 extends Thread {

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
		System.out.printf("Se sale del Hilo0: %s\n", this.getName());
	}

	public static void main(String args[]) {
		Hilo0 hilo = new Hilo0();
		hilo.setName("Hilo0");
		hilo.start();

		System.out.printf("Información del %s: %s\n", hilo.getName(), hilo.toString());
		System.out.println("El hilo se inicia, pero puede que todavía no haya terminado...");
		try {
			// retardo 2 segundos
			sleep(2000);
		} catch (InterruptedException e) {
				
		}
		
		if(hilo.isAlive()) {
			System.out.printf("El hilo %s se está ejecutando.\n", hilo.getName());
			hilo.interrupt();
			System.out.printf("El hilo %s se ha interrumpido.\n", hilo.getName());
		}
		else {
			System.out.printf("El hilo %s ha finalizado.\n", hilo.getName());
		}
		
		System.out.println("Fin de la ejecución del proceso padre.");
	}
	
	public void hiloEjecutandose() {
		System.out.printf("En este momento la CPU ejecuta: %s\n",currentThread().getName());
	}
}
