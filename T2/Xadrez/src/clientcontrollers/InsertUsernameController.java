package clientcontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientalert.AlertView;
import clientlogic.ClientSocketSingleton;
import clientviews.InsertUsernameView;

@SuppressWarnings("serial")
public class InsertUsernameController extends InsertUsernameView {

	
	public InsertUsernameController(){
		
		this.startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
	}
	
	private void register() {
		String user = this.getInsertUsernamePanel().getPlayerField().getText();
		if (user.length() > 12 || user.length() < 8){
			GamePresenter.getInstance().showAlert("Min 8 e max 12 caracters");
		} else {
			boolean wordOkay = true;
			for (int i = 0; i < user.length(); i++){
				char letter = user.charAt(i);
				if(Character.isLetter(letter) || Character.isDigit(letter)){
					continue;
				} else {
					GamePresenter.getInstance().showAlert("Invalid Caracter");
					wordOkay = false;
					break;
				}
			}
			if(wordOkay){
				ClientSocketSingleton.getInstance().getMessager().sendMessage("REGISTER:: " + user);
			}
		}
	}
}
