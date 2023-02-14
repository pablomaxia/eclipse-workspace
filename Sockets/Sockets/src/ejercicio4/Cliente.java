package ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import ejercicio1_sockets_TCP.Cliente2;

public class Cliente {

	public static void main(String[] args) {

		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";

		DataInputStream in;
		DataOutputStream out;
		Socket socket = null;

		try {

			String op = null;
			Scanner scanner = null;
			scanner = new Scanner(System.in);
			socket = new Socket(HOST, PUERTO);

			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("Escriba un número para enviar al servidor");
			int numero = scanner.nextInt();

			System.out.println("envio mensaje al servidor");
			out.writeInt(numero);
			
			System.out.println(in.readUTF());

			out.close();
			in.close();
			socket.close();

			scanner.close();
			System.out.println("Cliente desconectado");

		} catch (IOException e1) {
			Logger.getLogger(Cliente2.class.getName()).log(Level.SEVERE, null, e1);
		}
	}

}
