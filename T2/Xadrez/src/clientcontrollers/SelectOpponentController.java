package clientcontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientlogic.ClientSocketSingleton;
import clientviews.SelectOpponentView;

public class SelectOpponentController extends SelectOpponentView {
	
	public SelectOpponentController(){
		this.startButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String opponent = getSelectedValue();
				if (opponent != null){
					ClientSocketSingleton.getInstance().getMessager().sendMessage("PLAY:: " + opponent);
				}
			}
		});	
	}
}
