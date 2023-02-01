package ejercicio4;

public class HiloTarea extends Thread {

	public HiloTarea(String nombre, int prioridad, boolean demonio) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(demonio);
		start();
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			Mensaje mensaje = new Mensaje("MSG" + i);
			enviarMensaje(mensaje);
		}

	}

	public synchronized void enviarMensaje(Mensaje m) {
		System.out.println(getName() + " enterado de mensaje de: " + getName() + ": " + m.getTexto());
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		HiloTarea hilo1 = new HiloTarea("Thread-0", 2, false);
		HiloTarea hilo2 = new HiloTarea("Thread-1", 1, false);
	}
}
