package alert;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.ScreenDimensions;

@SuppressWarnings("serial")
public class AlertView extends JFrame {
	private final int FRAME_WIDTH = 200; 
	private final int FRAME_HEIGHT = 150;
	
	private AlertPanel panel;
	protected JButton button = new JButton("Ok");
	
	public AlertView(String msg) {
		panel = new AlertPanel(msg);
		getContentPane().add(panel);
		getContentPane().add(button);
		
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dismiss();
			}
		});
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		ScreenDimensions screen = ScreenDimensions.getScreenDimensions();
		int initialX = (int) (screen.screenCenterX - FRAME_WIDTH/2);
		int initialY = (int) (screen.screenCenterY - FRAME_HEIGHT/2);
		setBounds(initialX, initialY, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public AlertPanel getInsertUsernamePanel() {
		return panel;
	}
	
	private void dismiss(){
		this.setVisible(false);
	}
}
