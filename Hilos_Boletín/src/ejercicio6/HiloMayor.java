package ejercicio6;

class HiloMayor extends Thread {
    int[] vector;
    int inicio, fin;
    int mayor;

    void fijarRango(int inicio, int fin, int[] v) {
        this.inicio = inicio;
        this.fin = fin;
        this.vector = v;
    }

    public void run() {
    	mayor = vector[inicio];
        for (int fin = inicio + 1; fin < fin; fin++) {
            if (vector[fin] > mayor)
            	mayor = vector[fin];
        }
    }
}