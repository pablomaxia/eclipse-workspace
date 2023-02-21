package ejhilos1;

public class Hilo extends Thread {

	public Hilo(String nombre, int prioridad, boolean daemon) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(daemon);
	}

	@Override
	public void run() {
		System.out.println("INICIO HILO: " + getName());
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Hilo");
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
