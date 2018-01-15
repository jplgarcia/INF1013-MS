package client;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientSocketSingleton {

	private static ClientSocketSingleton instance = null;
	private ClientMessager messager = null;
	private ClientSocketSingleton(){
		System.out.println("Server: open port 5500");
	}
	
	public static synchronized ClientSocketSingleton getInstance(){
		if (instance == null){
			instance = new ClientSocketSingleton();
		}
		return instance;
	}

	public ClientMessager getMessager() {
		return messager;	
	}

	public void setMessager(ClientMessager messager) {
		this.messager = messager;
	}
	
	
}
