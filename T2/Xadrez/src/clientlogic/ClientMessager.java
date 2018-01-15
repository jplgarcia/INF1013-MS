package clientlogic;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMessager {
	
	private String username;
	private String color;
	private Socket socketConnection;
	private Scanner stdIn;
	private PrintStream stdOut;
	private Scanner serverOutput;
	private ClientReceiverRunnable runnable;
	
	public ClientMessager(String address, int port) {
		try {
			socketConnection = new Socket(address, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Client: connected to port " + port);
		
		configIO();
		
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
	public ClientReceiverRunnable getRunnable() {
		return runnable;
	}
	
	public void start() {
		startReceiving();
		//startSending();
	}
	
	private void startSending() {
		//Start sending messages
		String msg = stdIn.nextLine();
		while(msg.compareTo("###") != 0){
			stdOut.println(msg);
			msg = stdIn.nextLine();
		}
		closeConnection();
	}

	private void startReceiving() {
		runnable = new ClientReceiverRunnable(serverOutput);
		Thread thread = new Thread(runnable);
		thread.start();
	}
	
	public void sendMessage(String msg) {
		stdOut.println(msg);
	}

	private void configIO() {
		//Define IO
		stdIn = new Scanner(System.in);
		
		try {
			stdOut = new PrintStream(socketConnection.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			serverOutput = new Scanner(socketConnection.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		stdOut.close();
		stdIn.close();
		try {
			socketConnection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Client: disconnected");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
