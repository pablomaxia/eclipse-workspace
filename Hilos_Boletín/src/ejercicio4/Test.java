package ejercicio4;

public class Test {

	public static void main(String[] args) {
		HiloTarea hilo1, hilo2, hilo3;
		Mensaje msg = new Mensaje("");
		
		hilo1 = new HiloTarea("Thread-0", 3, false, msg);
		hilo2 = new HiloTarea("Thread-1", 2, false, msg);
		hilo3 = new HiloTarea("Thread-2", 1, false, msg);

		hilo1.start();
		hilo2.start();
		hilo3.start();
	}

}
