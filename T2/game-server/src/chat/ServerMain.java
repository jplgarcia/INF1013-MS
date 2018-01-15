package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat.Type;

public class ServerMain {
	
	private static Scanner in;

	public static void main (String args[]) throws IOException {
		
		ServerSingleton singleton = ServerSingleton.getInstance();
		singleton.startDroppingClients();
		singleton.startGettingClients();

		
	}
	
}
