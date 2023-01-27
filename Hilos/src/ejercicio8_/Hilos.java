package ejercicio8_;

public class Hilos {
	// Aplicación en Java con 2 hilos distintos.
	// 1 crea un archivo de texto que guarde 2 líneas de texto.
	// Otro crea un archivo de texto con los números del 1 al 50.
	// Primero se ejecuta el de las letras y después el de los números.
	// El tercer hilo tiene que buscar el número de veces que aparece la letra 'a' el primero.
	
	public static void main(String[] args) {
		HiloNumeros hilo0 = new HiloNumeros("HILO-NUMEROS", 1, false);
		hilo0.start();

		try {
			hilo0.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		HiloTexto hilo1 = new HiloTexto("HILO-TEXTO", 1, false);
		hilo1.start();

		try {
			hilo1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		HiloBusqueda hilo2 = new HiloBusqueda("HILO-BUSQUEDA", 1, false);
		hilo2.start();
		
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Se terminaron las tareas.");
	}
}
