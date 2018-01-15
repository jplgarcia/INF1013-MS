package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ServerClientManager implements Runnable {
	
	public void searchForClients() {
		//Get clients
		while(true){
			Socket client = null;
			try {
				client = ServerSingleton.getInstance().server.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Server: received connection from " + client.getInetAddress().getHostAddress());

			Thread thread = new Thread(new ServerRunnable(client));
			thread.start();
			
		}
	}

	@Override
	public void run() {
		searchForClients();
	}
}
