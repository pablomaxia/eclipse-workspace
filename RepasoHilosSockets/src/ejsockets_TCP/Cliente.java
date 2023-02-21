package ejsockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
	public static void main(String[] args) {

		final int PUERTO = 5001;
		final String HOST = "127.0.0.1";

		DataInputStream in;
		DataOutputStream out;
		Socket socket = null;

		try {

			String op = null;
			int i = 1;
			Scanner scanner = null;
			scanner = new Scanner(System.in);
			do {
				socket = new Socket(HOST, PUERTO);

				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());

				System.out.println("envio mensaje al servidor");
				out.writeUTF("llega mensaje desde el cliente! " + i++);
				System.out.println(in.readUTF());

				System.out.println("Desea Salir Si(s)/No(n):");
				op = scanner.next();
				out.close();
				in.close();
				socket.close();

			} while (op.equals("n"));
			scanner.close();
			System.out.println("Cliente desconectado");					

		} catch (IOException e1) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}
