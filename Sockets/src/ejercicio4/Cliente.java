package ejercicio4;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {

		// puerto del servidor
		final int PUERTO_SERVIDOR = 5000;
		// buffer donde se almacenara los mensajes
		byte[] buffer = new byte[1024];

		try {
			Scanner scanner = new Scanner(System.in);
			// Obtengo la localizacion de localhost
			InetAddress direccionServidor = InetAddress.getByName("localhost");

			// Creo el socket de UDP
			DatagramSocket socketUDP = new DatagramSocket();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(baos);

			System.out.println("Escriba un número");
			int numero = scanner.nextInt();

			dos.writeInt(numero);
			dos.flush();
			dos.close();
			// Convierto el mensaje a bytes
			buffer = baos.toByteArray();

			// Creo un datagrama
			DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

			// Lo envio con send
			System.out.println("Envio el datagrama");
			socketUDP.send(pregunta);
			
			// Reiniciar el buffer
			buffer = new byte[1024];
			// Preparo la respuesta
			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

			// Recibo la respuesta
			socketUDP.receive(peticion);
			System.out.println("Recibo la peticion");
			buffer = peticion.getData();

			// Cojo los datos y lo muestro
			String mensaje = new String(buffer);
			System.out.println(mensaje);

			// cierro el socket
			socketUDP.close();

		} catch (SocketException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnknownHostException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
