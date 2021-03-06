package views;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.ClientSocketSingleton;
import utils.ScreenDimensions;

@SuppressWarnings("serial")
public class InsertUsernameView extends JFrame {
	private final int FRAME_WIDTH = 300; 
	private final int FRAME_HEIGHT = 200;
	
	private InsertUsernamePanel playerPanel = new InsertUsernamePanel();
	protected JButton startButton = new JButton("Registrar");
	
	public InsertUsernameView() {
		getContentPane().add(playerPanel);
		getContentPane().add(startButton);
		
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		ScreenDimensions screen = ScreenDimensions.getScreenDimensions();
		int initialX = (int) (screen.screenCenterX - FRAME_WIDTH/2);
		int initialY = (int) (screen.screenCenterY - FRAME_HEIGHT/2);
		setBounds(initialX, initialY, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                ClientSocketSingleton.getInstance().getMessager().sendMessage("###:: me");
                e.getWindow().dispose();
            }
        });
	}
	
	public InsertUsernamePanel getInsertUsernamePanel() {
		return playerPanel;
	}
	
}
