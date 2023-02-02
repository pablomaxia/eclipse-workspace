package ejercicio5;

import java.io.File;

import javax.swing.JTextArea;

public class HiloBusqueda extends Thread {
	String directorio;
	JTextArea textArea;

	public HiloBusqueda(String directorio, JTextArea textArea) {
		this.directorio = directorio;
		this.textArea = textArea;
	}

	@Override
	public void run() {
		leer(directorio);
	}

	private void leer(String inicio) {

		File file = new File(inicio);
		String[] directorios = file.list();
		if (directorios != null)
			for (int i = 0; i < directorios.length; i++) {
				File ar2 = new File(inicio + directorios[i]);
				if (ar2.isFile())
					textArea.append(inicio + directorios[i] + "\n");
				if (ar2.isDirectory()) {
					textArea.append(inicio + directorios[i].toUpperCase() + " --> [Directorio]\n");
					leer(inicio + directorios[i] + "\\");
				}

			}
	}
}