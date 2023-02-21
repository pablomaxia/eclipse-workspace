package ejhilos1;

public class Prueba {

	public static void main(String[] args) {
		Hilo hilo = new Hilo("Hilo-0", Thread.MIN_PRIORITY, false);
		hilo.start();
	}

}
