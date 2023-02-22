package ejercicio3;

import java.io.File;

public class Prueba {

	public static void main(String args[]) {
		final File ARCHIVO1 = new File("ejercicio3_hilos1.txt");
		final File ARCHIVO2 = new File("ejercicio3_hilos2.txt");
		final File ARCHIVO3 = new File("ejercicio3_hilos3.txt");
		
		Hilo hilo1 = new Hilo("Hilo-0", 1, false, ARCHIVO1, 10, 20);
		Hilo hilo2 = new Hilo("Hilo-1", 1, false, ARCHIVO2, 20, 30);
		Hilo hilo3 = new Hilo("Hilo-2", 1, false, ARCHIVO3, 30, 40);

		hilo1.start();
		hilo2.start();
		hilo3.start();
	}

}
