package client;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Scanner;

import controllers.GamePresenter;

public class ClientReceiverRunnable extends Observable implements Runnable {

	private Scanner serverOutput;
	
	ClientReceiverRunnable(Scanner serverOutput) {
		this.serverOutput = serverOutput;
	}
	
	@Override
	public void run() {
		while(true){
			if (serverOutput.hasNextLine()) {
				String line = serverOutput.nextLine();
				String[] parts = line.split(":: "); 	// E:: msg de erro || S:: msg de sucesso
				String part1 = parts[0]; 			// E:: || S::
				String part2 = parts[1]; 			// msg de erro ||msg de sucesso
				
				if (part1.compareTo("ERROR") == 0) {
					GamePresenter.getInstance().showAlert(part2);
				} else if (part1.compareTo("PLAYERS") == 0) {
					updatePlayerList(part2);
				} else if (part1.compareTo("REGISTERED") == 0){
					ClientSocketSingleton.getInstance().getMessager().setUsername(part2);
					GamePresenter.getInstance().showPlayerList();
				} else if (part1.compareTo("INVITE") == 0){
					GamePresenter.getInstance().startGame();
				} else if (part1.compareTo("GMCMD") == 0){
					
				} else if (part1.compareTo("###") == 0){
					if (part2.compareTo("you") == 0){
						GamePresenter.getInstance().showAlert("You�ve timed out");
					} else {
						GamePresenter.getInstance().showAlert("Opponent disconnected");
					}
					break;
				}
				System.out.println(line);
			}
		}
		GamePresenter.getInstance().endgame();
	}
	
	private void updatePlayerList(String list) {
		String[] parts = list.split(",, ");
		ArrayList<String> playerNames = new ArrayList<String>(Arrays.asList(parts));
		playerNames.remove(0);
		this.setChanged();
		this.notifyObservers(playerNames);
	}
}
