package ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Hilo extends Thread {
	private File archivo;
	private int limite;
	private int inicio;
	boolean escribiendo = false;

	public Hilo(String nombre, int prioridad, boolean daemon, File archivo, int limite, int inicio) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(daemon);
		this.archivo = archivo;
		this.limite = limite;
		this.inicio = inicio;
	}

	@Override
	public void run() {
		System.out.println("INICIO HILO: " + getName());
		escribirNumeros();
	}

	private synchronized void escribirNumeros() {
		FileWriter writer;
		try {
			writer = new FileWriter(archivo);

			synchronized (writer) {
				while(escribiendo)
					wait();
				for (int i = 0; i <= 10; i++) {
					escribiendo = true;
					writer.write(String.valueOf((int) (Math.random() * limite + inicio)) + "\n");
				}
				escribiendo = false;
				notifyAll();
				writer.close();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
