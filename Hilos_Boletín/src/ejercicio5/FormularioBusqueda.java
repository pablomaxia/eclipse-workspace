package ejercicio5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FormularioBusqueda extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 111671531220113609L;
	JTextArea textArea;
	JScrollPane scrollPane;
	JButton boton;

	FormularioBusqueda() {
		setLayout(null);
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 30, 760, 300);
		add(scrollPane);

		boton = new JButton("Salir");
		boton.addActionListener(this);
		boton.setBounds(320, 350, 100, 30);
		add(boton);

		textArea.setText("");
		HiloBusqueda hb = new HiloBusqueda("c:\\", textArea);
		hb.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton)
			System.exit(0);

	}

	public static void main(String[] arguments) {
		FormularioBusqueda fb;
		fb = new FormularioBusqueda();
		fb.setBounds(0, 0, 800, 640);
		fb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fb.setVisible(true);
	}
}