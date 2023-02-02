package ejercicio7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BuscarPalabra extends Thread {
	private String palabra;
	private int cantidad;
	private String ruta = "C:\\Documents";

	public BuscarPalabra(String palabra) {
		this.palabra = palabra;

		start();
		while (isAlive());
		System.out.println("La palabra " + palabra + " se encuentra contenida en " + cantidad + " archivos");
	}

	@Override
	public void run() {
		File file = new File(ruta);
		String[] directorio = file.list();
		for (String arch : directorio) {
			if (tiene(arch))
				cantidad++;
		}
	}

	private synchronized boolean tiene(String archivo) {
		boolean existe = false;
		try {
			FileReader fr = new FileReader(ruta + "\\" + archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				if (linea.indexOf(palabra) != -1)
					existe = true;
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return existe;
	}

	public static void main(String[] file) {
		new BuscarPalabra("rojo");
		new BuscarPalabra("verde");

	}

}
