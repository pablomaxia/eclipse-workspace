package ejercicio12_banco_uso_bloqueoConObject.copy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*clase que crea las cuentas*/
public class Banco {
	private final Double[] cuentas; // array donde se guarda el saldo de cada cuenta

	// private Lock cierreBanco;

	// private Condition saldoSuficiente;

	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, Double cantidad)
			throws InterruptedException {
		// bloqueo el trozo de código para que solo pueda ser ejecutado por un hilo a la
		// vez. El problema es que hay hilos que mueren y no realizan su trabajo
		// cierreBanco.lock();

		// try {
		while (cuentas[cuentaOrigen] < cantidad) {
			// quitamos el return porque queremos que todas las transferencia se realicen,
			// pone un hilo a la espera y desbloquea el código para que pueda entrar otro
			// hilo.
			// saldoSuficiente.await();
			wait(); // es de la clase Object SOLO SI EL MÉTODO ES SYNCHORNIZED
		}
		System.out.println(Thread.currentThread());
		cuentas[cuentaOrigen] -= cantidad;
		System.out.printf("Cantidad transferida: %.2f de Cuenta origen %d para cuenta destino %d", cantidad,
				cuentaOrigen, cuentaDestino);
		cuentas[cuentaDestino] += cantidad;
		System.out.printf("\n Saldo total: %.2f%n", this.getSaldoTotal());

		// informa a todos los hilos para que despierten los hilos que están a la espera
		// saldoSuficiente.signalAll();
		notifyAll(); // de la clase Object
		// } finally {
		// cierreBanco.unlock();
		// }
	}

	public Double getSaldoTotal() {
		Double suma_cuentas = 0.0;

		for (Double a : cuentas) {
			suma_cuentas += a;
		}
		return suma_cuentas;
	}

	public Banco() {
		// inicialmente a cada cuenta se le asignan 2000 euros
		// en el banco hay 100 cuentas
		cuentas = new Double[100];
		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000.0;
		}
		// cierreBanco = new ReentrantLock();// Instancia el cierre

		// saldoSuficiente = cierreBanco.newCondition();// Asigna la condición al cierre
	}

	public Double[] getCuentas() {
		return cuentas;
	}

}
