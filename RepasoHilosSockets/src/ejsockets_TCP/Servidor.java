package ejsockets_TCP;

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

		final int PUERTO = 5001;

		// los mensajes viajan a través de estos objetos.
		// Las clases DataInputStream y DataOutputStream sirven para leer/escribir datos
		// del tipo primitivo de una forma portable
		DataInputStream in;
		DataOutputStream out;
		System.out.println("Servidor iniciado");
		while (true) {
			try {
				servidor = new ServerSocket(PUERTO);

				// el servidor se mantiene a la escucha hasta que le llega a través del socket
				// un mensaje
				socket = servidor.accept();

				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());

				String mensaje = in.readUTF();
				System.out.println(mensaje);

				out.writeUTF("ok ");

				in.close();
				out.close();
				socket.close();
				servidor.close();

			}

			catch (IOException e1) {
				Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
			}
		}

	}
}