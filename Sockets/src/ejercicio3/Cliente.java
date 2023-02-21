package ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {

		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";

		DataInputStream in;
		DataOutputStream out;

		try {

			Socket socket = new Socket(HOST, PUERTO);

			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

			int numero = 2;
			System.out.println("El cliente envía un mensaje al servidor ...");
			System.out.println("Mensaje CLIENTE: " + numero);
			out.writeFloat(numero);

			System.out.println("El cliente es respondido por el servidor ...");
			float mensaje = in.readFloat();
			System.out.println("El cliente envía un mensaje al servidor ...");
			System.out.println("Mensaje SERVIDOR: Cuadrado de " + numero + ": " + mensaje); // Mensaje del servidor

			socket.close();

		} catch (IOException e1) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e1);
		}
	}

}
