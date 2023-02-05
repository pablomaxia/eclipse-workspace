package ejercicio4;

public class HiloTarea extends Thread {
	static HiloTarea hilo1, hilo2;

	public HiloTarea(String nombre, int prioridad, boolean demonio) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(demonio);
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			Mensaje mensaje = new Mensaje("MSG" + i);
			Thread hilo = null; 
			
			hilo = currentThread() == hilo1? hilo2: hilo1;
			enviarMensaje(mensaje,hilo);
		}

	}

	public synchronized void enviarMensaje(Mensaje m, Thread t) {

		System.out.println(getName() + " enterado de mensaje de: " + t.getName() + ": " + m.getTexto());
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			hilo1 = new HiloTarea("Thread-0", 2, false);
			hilo2 = new HiloTarea("Thread-1", 1, false);

			hilo1.start();
			hilo2.start();

			hilo1.join();
			hilo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
