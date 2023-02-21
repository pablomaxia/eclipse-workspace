package ejercicio4;

/**
 * 
 * Los métodos sincronizados en Java solo pueden tener un hilo ejecutándose
 * dentro de ellos al mismo tiempo.
 * 
 * Son necesarios cuando un método accede a un recurso que puede ser consumido
 * por un único proceso.
 * 
 * Para evitar que un algoritmo sea ejecutado por más de un hilo en forma
 * simultanea, Java nos permite definir un método con el modificador:
 * synchronized.
 * 
 * Cuando un método se le define synchronized luego solo un hilo puede estar
 * ejecutándolo en un mismo momento.
 *
 */
public class HiloTarea extends Thread {
	private Mensaje mensaje;

	public HiloTarea(String nombre, int prioridad, boolean demonio, Mensaje msg) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(demonio);
		this.mensaje = msg;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			enviarMensaje(this.mensaje, i);
			/*
			 * synchronized (this.mensaje) { System.out.println(getName() +
			 * " enterado de mensaje de: " + this.mensaje.getTexto());
			 * this.mensaje.setTexto(this.getName() + ": MSG" + i); } try { sleep(3000); }
			 * catch (InterruptedException e) { e.printStackTrace(); }
			 */
		}

	}

	public void enviarMensaje(Mensaje m, int i) {
		synchronized (this.mensaje) {
			System.out.println(getName() + " enterado de mensaje de: " + this.mensaje.getTexto());
			this.mensaje.setTexto(this.getName() + ": MSG" + i);
		}
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
