package ejercicio5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String[] args) {

		ServerSocket servidor = null;

		// se abre un puente de comunicación entre el servidor y el cliente
		Socket socket = null;

		final int PUERTO = 5000;

		// los mensajes viajan a través de estos objetos.
		// Las clases DataInputStream y DataOutputStream
		// sirven para leer/escribir datos del tipo primitivo de una forma portable
		DataInputStream in;
		DataOutputStream out;

		try {
			servidor = new ServerSocket(PUERTO);

			System.out.println("Servidor iniciado");

			while (true) {
				// el servidor se mantiene a la escucha
				// hasta que le llega a través del socket un mensaje
				socket = servidor.accept();

				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());

				System.out.println("El servidor recibe el mensaje del cliente ...");// Mensaje del cliente

				float numero = in.readFloat();
				float numero2 = in.readFloat();


				System.out.println("El servidor responde el mensaje del cliente ...");// Mensaje del cliente

				float suma = numero + numero2;
				float resta = numero - numero2;
				float multiplicacion = numero * numero2;
				float division = numero2 > 0? numero / numero2: 0;

				out.writeFloat(suma);
				out.writeFloat(resta);
				out.writeFloat(multiplicacion);
				out.writeFloat(division);

				socket.close();

				System.out.println("El cliente se ha desconectado");

			}

		} catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}
