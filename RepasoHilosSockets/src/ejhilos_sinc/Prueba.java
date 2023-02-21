package ejhilos_sinc;

public class Prueba {
	public static void main(String args[]) {
		Emisor send = new Emisor();
		Hilo S1 = new Hilo("Hilo-0", Thread.MIN_PRIORITY, false, " Hola ", send);
		Hilo S2 = new Hilo("Hilo-1", Thread.MIN_PRIORITY, false, " Adiós ", send);

		S1.start();
		S2.start();

		try {
			S1.join();
			S2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
