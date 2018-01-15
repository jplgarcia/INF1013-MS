package controllers;

import javax.swing.JFrame;

import alert.AlertView;
import client.ClientSocketSingleton;
import views.GameStartedView;
import views.InsertUsernameView;

public class GamePresenter {
	private static GamePresenter gamePresenter = null;
	private InsertUsernameController insertUsernameController = new InsertUsernameController();
	private SelectOpponentController selectOpponentController = new SelectOpponentController();
	private GameStartedController gameStartedController = new GameStartedController();
	
	/**
	 * Initializes the facade
	 */
	private GamePresenter() {
	}
	
	/**
	 * If not already initialized: initializes the singleton
	 * as an single instance and returns it
	 * If initialized only returns the instance
	 * @return the instanced Game Controller
	 */
	public static GamePresenter getInstance() {
		if(gamePresenter == null) {
			gamePresenter = new GamePresenter();
		}
		return gamePresenter;
	}
	
	/**
	 * Initializes the naming frame and sets it visible
	 */
	public void initiateGame() { 
		insertUsernameController.setTitle("Insira um nome de usu�rio"); 
		insertUsernameController.setVisible(true);
		//GameController.getMainGameManager().setGameStage(GameStage.naming);
	}
	
	public void showPlayerList() {
		insertUsernameController.setVisible(false);
		selectOpponentController.setTitle("Esolha seu oponente");
		selectOpponentController.setVisible(true);
		ClientSocketSingleton.getInstance().getMessager().getRunnable().addObserver(selectOpponentController);
	}
	
	public void startGame() {
		selectOpponentController.setVisible(false);
		gameStartedController.setVisible(true);
	}
	
	public void showAlert(String msg) {
		AlertView alert = new AlertView(msg);
		alert.setTitle("Alerta");
		alert.setVisible(true);
	}
	
	public void endgame() {
		insertUsernameController.setVisible(false);
		selectOpponentController.setVisible(false);
		gameStartedController.setVisible(false);
		ClientSocketSingleton.getInstance().getMessager().closeConnection();
	}
}
