package alert;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AlertPanel extends JPanel {

	private Label label = new Label("label ");
	
	public AlertPanel(String msg) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
		label.setText(msg);
		add(label);
	}
}
