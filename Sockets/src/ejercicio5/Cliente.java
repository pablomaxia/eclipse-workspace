package ejercicio5;

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
			int numero2 = 5;
			System.out.println("El cliente envía un mensaje al servidor ...");
			//System.out.println("Mensaje CLIENTE: " + numero);
			out.writeFloat(numero);
			out.writeFloat(numero2);

			System.out.println("El cliente es respondido por el servidor ...");
			float suma = in.readFloat();
			float resta = in.readFloat();
			float multiplicacion = in.readFloat();
			float division = in.readFloat();
			System.out.println("El cliente envía un mensaje al servidor ...");
			System.out.println("Mensaje SERVIDOR: Suma de " + numero + " y " + numero2 + " : " + suma); // Mensaje del servidor
			System.out.println("Mensaje SERVIDOR: Resta de " + numero + " y " + numero2 + " : " + resta); // Mensaje del servidor
			System.out.println("Mensaje SERVIDOR: Producto de " + numero + " y " + numero2 + " : " + multiplicacion); // Mensaje del servidor
			System.out.println("Mensaje SERVIDOR: Division de " + numero + " y " + numero2 + " : " + division); // Mensaje del servidor

			socket.close();

		} catch (IOException e1) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e1);
		}
	}

}
