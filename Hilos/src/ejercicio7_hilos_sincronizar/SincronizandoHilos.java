package ejercicio7_hilos_sincronizar;

public class SincronizandoHilos {

	public static void main(String[] args) {
		Hilo hilo0 = new Hilo("HILO-0", 1, false);
		hilo0.start();

		try {
			hilo0.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Hilo hilo1 = new Hilo("HILO-1", 1, false);
		hilo1.start();
		
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Se terminaron las tareas.");
	}
}
