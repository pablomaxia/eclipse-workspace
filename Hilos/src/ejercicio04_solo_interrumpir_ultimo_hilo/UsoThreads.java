package ejercicio04_solo_interrumpir_ultimo_hilo;

import javax.swing.JFrame;

public class UsoThreads {

	public static void main(String[] args) {
		JFrame marco = new MarcoRebote();

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);
	}

}
