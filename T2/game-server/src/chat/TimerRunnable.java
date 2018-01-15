package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.Timer;

public class TimerRunnable implements Runnable, ActionListener {
	
	private Timer t;
	
	TimerRunnable() {
		t = new Timer(10000, this);
	}

	@Override
	public void run() {
		while(true) {
			startTimer();
		}
	}

	private void startTimer() {
		if(!t.isRunning()){
			t.restart();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		long currentTime = System.currentTimeMillis();
		HashMap<String, Player> users = ServerSingleton.getInstance().getUsersHash();
		for (Entry<String, Player> entry : users.entrySet()) {
		    String key = entry.getKey();
		    Player value = entry.getValue();
		    if (value.getOpponent() != null) {
		    	if ((currentTime - value.getLastPlayed()) >= 60000){
		    		ServerSingleton.getInstance().endgameByTimer(key, value.getOpponent().getUsername());
		    	}
		    }
		}
	}
}
