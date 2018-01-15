package chat;

import java.io.PrintStream;
import java.net.Socket;

public class Player {
	private String username;
	private long lastPlayed;
	private Player opponent = null;
	private Socket client;
	private PrintStream outStream;
	
	public Player(String username, Socket client, PrintStream outStream){
		this.username = username;
		this.client = client;
		this.outStream = outStream;
		renewLastPlayed();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public long getLastPlayed() {
		return lastPlayed;
	}
	public void setLastPlayed(long lastPlayed) {
		this.lastPlayed = lastPlayed;
	}
	public void renewLastPlayed() {
		lastPlayed = System.currentTimeMillis();
	}
	
	public Player getOpponent() {
		return opponent;
	}
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	public Socket getClient() {
		return client;
	}
	public void setClient(Socket client) {
		this.client = client;
	}

	public PrintStream getOutStream() {
		return outStream;
	}

	public void setOutStream(PrintStream outStream) {
		this.outStream = outStream;
	}
	
}
