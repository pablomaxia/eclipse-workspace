package ejercicio6;

import java.util.Date;

public class Vector {

    public static void main(String[] args) {
        int[] vector = new int[500000000];

        System.out.println("Inicio de la carga del vector.");
        for (int f = 0; f < vector.length; f++)
            vector[f] = (int) (Math.random() * 2000000000);
        
        System.out.println("Fin de la carga del vector.");
        Date fecha1 = new Date();

        HiloMayor hilo1 = new HiloMayor();
        hilo1.fijarRango(0, vector.length / 2, vector);
        
        HiloMayor hilo2 = new HiloMayor();
        hilo2.fijarRango(vector.length / 2 + 1, vector.length - 1, vector);
        
        hilo1.start();
        hilo2.start();

        while (hilo1.isAlive() || hilo2.isAlive()) ;

        System.out.print("Mayor elemento del vector: ");
        
        HiloMayor hilo;
        hilo = hilo1.mayor > hilo2.mayor? hilo1: hilo2;
        System.out.println(hilo.mayor);

        Date fecha2 = new Date();
        long milisegundos = (fecha2.getTime() - fecha1.getTime());

        System.out.println("Milisegundos requeridos con 2 hilos: " + milisegundos);

        fecha1 = new Date();
        int mayor = vector[0];
        
        for (int f = 1; f < vector.length; f++) {
            if (vector[f] > mayor)
                mayor = vector[f];
        }
        
        System.out.println("Mayor elemento del vector: " + mayor);
        
        fecha2 = new Date();
        milisegundos = (fecha2.getTime() - fecha1.getTime());
        
        System.out.println("Milisegundos requeridos sin hilos: " + milisegundos);

    }
}
