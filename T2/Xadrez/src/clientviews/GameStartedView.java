package clientviews;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import clientlogic.ClientSocketSingleton;
import clientutils.ScreenDimensions;

@SuppressWarnings("serial")
public class GameStartedView extends JFrame {
	private final int FRAME_WIDTH = 500; 
	private final int FRAME_HEIGHT = 500;
	
	protected GameStartedPanel panel = new GameStartedPanel();
	protected JButton startButton = new JButton("Iniciar");
	
	public GameStartedView() {
		getContentPane().add(panel);
	
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
}
