package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.ClientSocketSingleton;
import views.SelectOpponentView;

public class SelectOpponentController extends SelectOpponentView {
	
	public SelectOpponentController(){
		this.startButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String opponent = getSelectedValue();
				ClientSocketSingleton.getInstance().getMessager().sendMessage("PLAY:: " + opponent);
			}
		});	
	}
}
