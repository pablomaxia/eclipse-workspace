package ejercicio7_hilos_sincronizar;

public class Hilo extends Thread {
	
	public Hilo(String nombre, int prioridad, boolean demonio) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(demonio);
	}
	@Override
	public void run() {
		for (int i = 0; i <= 25; i++) {
			System.out.println("Ejecutando hilo " + this.getName());
		}
	}
}
