package ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Hilo extends Thread {
	private File archivo;
	boolean leyendo = false;

	public Hilo(String nombre, int prioridad, boolean daemon, File archivo) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(daemon);
		this.archivo = archivo;
	}

	@Override
	public void run() {
		System.out.println("INICIO HILO: " + getName());
		leerFichero();
	}

	private synchronized void leerFichero() {
		FileReader fileReader;
		BufferedReader br;
		try {
			fileReader = new FileReader(archivo);
			br = new BufferedReader(fileReader);
			try {
				// Solo 2 líneas a la vez
				synchronized (fileReader) {
					while (leyendo) {
						wait();
					}
					for (int i = 0; i < 2; i++) {
						leyendo = true;
						System.out.println(getName() + " lee : " + br.readLine());

					}
					leyendo = false;
					notifyAll();
				}
				fileReader.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

}
