package clientviews;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InsertUsernamePanel extends JPanel {

	private JTextField playerField = new JTextField("Jogador");
	private Label playerLabel = new Label("Nome: ");
	
	public InsertUsernamePanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
		
		add(playerLabel);
		add(getPlayerField());
		
	}
	
	

	public JTextField getPlayerField() {
		return playerField;
	}

	public void setPlayerField(JTextField playerField) {
		this.playerField = playerField;
	}
}
