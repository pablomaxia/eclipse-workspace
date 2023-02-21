package ejhilos_sinc;

public class Hilo extends Thread {
	private String mensaje;
	Emisor emisor;

	public Hilo(String nombre, int prioridad, boolean daemon, String mensaje, Emisor emisor) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(daemon);
		this.mensaje = mensaje;
		this.emisor = emisor;
	}

	@Override
	public void run() {
		System.out.println("INICIO HILO: " + getName());
		try {
			// Solo un mensaje a la vez
			synchronized (emisor) {
				emisor.send(mensaje);
			}
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
