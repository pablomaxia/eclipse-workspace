package ejercicio10_banco_uso_RentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*clase que crea las cuentas*/
public class Banco {
	private final Double[] cuentas; // array donde se guarda el saldo de cada cuenta

	private Lock cierreBanco;

	public void transferencia(int cuentaOrigen, int cuentaDestino, Double cantidad) {
		// bloqueo el trozo de código para que solo pueda ser ejecutado por un hilo a la
		// vez. El problema es que hay hilos que mueren y no realizan su trabajo
		cierreBanco.lock();

		try {
			if (cuentas[cuentaOrigen] < cantidad) {
				return; // si el saldo de la cuenta es inferior a la cuenta a transferir
						// no hace nada se sale pero siempre entra en finally
			}
			System.out.println(Thread.currentThread());
			cuentas[cuentaOrigen] -= cantidad;
			System.out.printf("Cantidad transferida: %.2f de Cuenta origen %d para cuenta destino %d", cantidad,
					cuentaOrigen, cuentaDestino);
			cuentas[cuentaDestino] += cantidad;
			System.out.printf("\n Saldo total: %.2f%n", this.getSaldoTotal());
		} finally {
			cierreBanco.unlock();
		}
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
		cierreBanco = new ReentrantLock();// Instancia el cierre
	}

	public Double[] getCuentas() {
		return cuentas;
	}

}
