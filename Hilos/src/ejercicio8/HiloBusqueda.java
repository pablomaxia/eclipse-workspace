package ejercicio8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HiloBusqueda extends Thread {
	private String cadenaBusqueda;

	public HiloBusqueda(String nombre, int prioridad, boolean demonio, String cadenaBusqueda) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(demonio);
		this.cadenaBusqueda = cadenaBusqueda;
	}

	@Override
	public void run() {
		int count = 0;
		try {
			FileReader fr = new FileReader("texto.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			do {
				count += (linea.length() - linea.replace(this.cadenaBusqueda, "").length()) / this.cadenaBusqueda.length();
				linea = br.readLine();
				System.out.println("Ejecutando hilo " + this.getName());
			} while (linea != null);
			fr.close();
			System.out.println("La cadena " + this.cadenaBusqueda + " aparece: " + count + " veces.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
