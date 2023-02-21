package ejercicio4;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String[] args) {

		final int PUERTO = 5000;
		byte[] buffer = new byte[1024];

		try {
			System.out.println("Iniciado el servidor UDP");
			// Creación del socket
			DatagramSocket socketUDP = new DatagramSocket(PUERTO);
			// DatagramSocket es equivalente a nuestro Socket anterior
			// Siempre atenderá peticiones
			while (true) {

				// Preparo la respuesta (creo un paquete con información del buffer donde
				// guardar y la longitud del mismo
				DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

				// Recibo el datagrama (como el inputReader)
				// no se sabe quién contacta aún
				socketUDP.receive(peticion);
				System.out.println("Recibo la informacion del cliente");

				// Convierto lo recibido y mostrar el mensaje
				// How to read data from a byte stream:
				byte[] buff = peticion.getData();
				ByteArrayInputStream bais = new ByteArrayInputStream(buff);
				DataInputStream dis = new DataInputStream(bais);
				int numero = dis.readInt(); // read an int
				dis.close(); // !!! close stream
				String mensaje = String.valueOf(numero);
				// String mensaje = new String(peticion.getData()).trim();
				// int numero = Integer.parseInt(mensaje);

				// Obtengo el puerto y la direccion de origen
				// Sino se quiere responder, no es necesario
				int puertoCliente = peticion.getPort();
				InetAddress direccion = peticion.getAddress();

				for (int i = 1; i <= 10; i++) {
					mensaje += String.format(" %d", numero + i);
				}
				
				buffer = mensaje.getBytes();

				// creo el datagrama
				DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

				// Envio la información
				System.out.println("Envio la informacion del cliente: " + mensaje);
				socketUDP.send(respuesta);

			}

		} catch (SocketException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}