package ejercicio1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
	public static void main(String[] args) {

		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		final File ARCHIVO = new File("ejercicio1_cliente.txt");
		
		String[] mensaje = new String[] {""};
		DataInputStream in;
		DataOutputStream out;
		FileReader fileReader;
		BufferedReader br;
		
		Socket socket = null;

		try {
			socket = new Socket(HOST, PUERTO);

			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

			fileReader = new FileReader(ARCHIVO);
			br = new BufferedReader(fileReader);
			
			System.out.println("Se envía el mensaje al servidor");
			int index = 0;
			while (br.ready()) {
				mensaje[index] = br.readLine();
				out.writeUTF(mensaje[index]);
				index++;
			}

			System.out.println(in.readUTF());

			out.close();
			in.close();
			fileReader.close();
			br.close();
			socket.close();

			System.out.println("Cliente desconectado");

		} catch (IOException e1) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}
