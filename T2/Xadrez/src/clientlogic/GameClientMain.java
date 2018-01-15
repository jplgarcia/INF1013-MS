package clientlogic;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import clientcontrollers.GamePresenter;
import clientviews.InsertUsernamePanel;

public class GameClientMain {
	public static void main (String args[]) throws IOException {
		ClientSocketSingleton.getInstance().setMessager(new ClientMessager("127.0.0.1", 5500));
		ClientSocketSingleton.getInstance().getMessager().start();
		GamePresenter.getInstance().initiateGame();
	}
}
