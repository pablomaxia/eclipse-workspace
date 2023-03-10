package hilo;

public class HiloRunnable implements Runnable {

	public void run() {

		//hiloEjecutandose();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		System.out.println("Se sale del Hilo0");
	}

	public static void main(String args[]) {
		Runnable r = new HiloRunnable();
		Thread hilo = new Thread(r);
		
		hilo.setName("Hilo0");
		hilo.start();

		System.out.printf("Información del %s: %s\n", hilo.getName(), hilo.toString());
		System.out.println("El hilo se inicia, pero puede que todavía no haya terminado...");
		try {
			// retardo 2 segundos
			Thread.sleep(2000);
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
	
	//public void hiloEjecutandose() {
	//	System.out.printf("En este momento la CPU ejecuta: %s\n", hilo.getName());
	//}
}
