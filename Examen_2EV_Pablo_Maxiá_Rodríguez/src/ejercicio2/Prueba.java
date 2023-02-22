package ejercicio2;

import java.io.File;

public class Prueba {
	public static void main(String args[]) {
		final File ARCHIVO = new File("ejercicio2_hilos.txt");
		Hilo S1 = new Hilo("Hilo-0", 2, false, ARCHIVO);
		Hilo S2 = new Hilo("Hilo-1", Thread.MIN_PRIORITY, false, ARCHIVO);

		S1.start();

		try {
			S1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		S2.start();
	}

}
