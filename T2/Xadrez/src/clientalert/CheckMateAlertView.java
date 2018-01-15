package clientalert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import clientcontrollers.GamePresenter;

@SuppressWarnings("serial")
public class CheckMateAlertView extends AlertView {

	public CheckMateAlertView(String msg) {
		super(msg);
		
		
		addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
            	GamePresenter.getInstance().endgame();
                e.getWindow().dispose();
            }
        });
		
		this.button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePresenter.getInstance().endgame();
				dismiss();
			}
		});
	}
	
	

}
