package ejercicio2;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Hilo hilo = new Hilo("Hilo", 1);
		HiloDemonio hiloDaemon = new HiloDemonio("Daemon", 1);
		if (hilo.isAlive() || hiloDaemon.isAlive()) {
			Scanner tec = new Scanner(System.in);
			int num1 = 0;
			int num2 = 0;
			System.out.println("Introduzca el primer número: ");
			num1 = tec.nextInt();
			System.out.println("Introduzca el segundo número: ");
			num2 = tec.nextInt();

			while (num2 < num1) {
				System.out.println(num1);
				num1++;
			}
			if (!hilo.isDaemon())
				System.out.println("La tarea es un hilo.");
			System.out.println("La tarea es un demonio.");
		}
		hilo.interrupt();
		hiloDaemon.interrupt();
	}
}
