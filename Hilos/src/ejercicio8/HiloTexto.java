package ejercicio8;

import java.io.FileWriter;
import java.io.IOException;

public class HiloTexto extends Thread {
	public HiloTexto(String nombre, int prioridad, boolean demonio) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(demonio);
	}

	@Override
	public void run() {
		String[] vocales = new String[] { "a", "e", "i", "o", "u" };
		try {
			FileWriter fw = new FileWriter("texto.txt");
				fw.write("Esta es la primera línea\n");
				fw.write("Esta es la segunda línea\n");
				System.out.println("Ejecutando hilo " + this.getName());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
