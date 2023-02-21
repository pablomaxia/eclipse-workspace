package ejhilos_demonio;

public class Prueba {
	public static void main(String[] args) {
		HiloDemonio hilo1 = new HiloDemonio("DEMONIO", Thread.MIN_PRIORITY, true, 16);
		HiloDemonio hilo2 = new HiloDemonio("HILO", 2, false, 3);

		hilo1.start();
		hilo2.start();
		/*try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hilo2.start();*/
	}

}
