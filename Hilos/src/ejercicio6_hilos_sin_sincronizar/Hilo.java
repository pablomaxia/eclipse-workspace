package ejercicio6_hilos_sin_sincronizar;

public class Hilo extends Thread {
	
	public Hilo(String nombre, int prioridad, boolean demonio) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(demonio);
		start();
	}
	@Override
	public void run() {
		for (int i = 0; i <= 25; i++) {
			System.out.println("Ejecutando hilo " + this.getName());
		}
	}
}
