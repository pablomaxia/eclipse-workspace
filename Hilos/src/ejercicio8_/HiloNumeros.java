package ejercicio8_;

import java.io.FileWriter;
import java.io.IOException;

public class HiloNumeros extends Thread {
	public HiloNumeros(String nombre, int prioridad, boolean demonio) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(demonio);
	}

	@Override
	public void run() {
		try {
			FileWriter fw = new FileWriter("numeros.txt");
			for (int i = 1; i <= 50; i++) {
				fw.write(String.valueOf(i) + "\n");
				System.out.println("Ejecutando hilo " + this.getName());
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
