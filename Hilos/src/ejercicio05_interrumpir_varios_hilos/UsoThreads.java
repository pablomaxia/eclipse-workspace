package ejercicio05_interrumpir_varios_hilos;
import javax.swing.JFrame;
/*
 * vamos a realizar el ejercicio 1 permitiendo varios hilos de ejecución
 * 
 */
public class UsoThreads {

	public static void main(String[] args) {
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
		
    }

}



