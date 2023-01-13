package ejercicio2;

import java.util.Scanner;

public class HiloDemonio extends Thread {
	public HiloDemonio(String nombre, int prioridad, boolean daemon) {
		setName(nombre);
		setPriority(prioridad);
		setDaemon(daemon);
		start();
	}

	@Override
	public void run() {
		Scanner tec = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		String proceso = "";
		System.out.println("Introduzca el primer número: ");
		num1 = tec.nextInt();
		System.out.println("Introduzca el segundo número: ");
		num2 = tec.nextInt();
		tec.close();

		if (isDaemon()) {
			proceso = "del demonio";
		}
		else {
			proceso = "de la aplicación";
		}
		
		System.out.printf("%s: Ejecución %s", getName(), proceso);
		
		while (true) {
			try {
				sleep(1000); // 1 segundo (se mide en milisegundos)
				while (num2 >= num1) {
					System.out.println(num1);
					num1++;
				}
			} catch (InterruptedException e) {
				e.getMessage();
			}
			if (interrupted()) {
				System.out.println("El hilo fue interrumpido");
			}
			System.out.printf("Se sale del Hilo: %s\n", this.getName());
			System.out.println("Tarea finalizada");

		}
	}
	public static void main(String args[]) {
		HiloDemonio demonio = new HiloDemonio("DEMONIO", 1, false);
		HiloDemonio demonio2 = new HiloDemonio("DEMONIO2", 1, true);
	}
}
