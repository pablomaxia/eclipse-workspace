package ejhilos_sinc;

public class Emisor {
	public void send(String msg) {
		System.out.println(Thread.currentThread() + " Enviando \t" + msg);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n" + msg + "enviado");
	}
}