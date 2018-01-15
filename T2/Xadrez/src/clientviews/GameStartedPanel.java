package clientviews;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class GameStartedPanel extends JPanel {
	private Label label = new Label("O JOGO COME�OU");
	
	public GameStartedPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(label);
	}
}
