package ejercicio8_;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HiloBusqueda extends Thread {
	public HiloBusqueda(String nombre, int prioridad, boolean demonio) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(demonio);
	}

	@Override
	public void run() {
		String[] vocales = new String[] { "a", "e", "i", "o", "u" };
		int count = 0;
		try {
			FileReader fr = new FileReader("texto.txt");
			while (fr.ready()) {
				int linea = fr.read();
				if (linea == Integer.valueOf('a')) {
					count ++;
				}
				System.out.println("Ejecutando hilo " + this.getName());
			}
			System.out.println("La letra 'a' aparece: " + count + " veces.");
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
