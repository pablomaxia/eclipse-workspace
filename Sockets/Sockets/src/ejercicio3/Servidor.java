package ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ejercicio1_sockets_TCP.Servidor2;

public class Servidor {

	public static void main(String[] args) {

		ServerSocket servidor = null;

		// se abre un puente de comunicación entre el servidor y el cliente
		Socket socket = null;

		final int PUERTO = 5000;

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

				int num = in.readInt();
				int cuadrado = num*num;
				System.out.println(cuadrado);

				out.writeInt(cuadrado);

				in.close();
				out.close();
				socket.close();
				servidor.close();

			}

			catch (IOException e1) {
				Logger.getLogger(Servidor2.class.getName()).log(Level.SEVERE, null, e1);
			}
		}

	}
}
