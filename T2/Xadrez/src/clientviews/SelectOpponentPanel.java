package clientviews;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clientlogic.ClientSocketSingleton;

@SuppressWarnings("serial")
public class SelectOpponentPanel extends JPanel {
	private Label label = new Label("Escolha o jogador contra quem voce deseja jogar");
	private JList list;
	private DefaultListModel model;
	
	public SelectOpponentPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		model = new DefaultListModel();
	    setList(new JList(model));
	    JScrollPane pane = new JScrollPane(getList());
	    
	    loadListElements();
	 
		add(label);
		add(pane);
	}
	
	private void loadListElements () {
		for (int i = 0; i < 15; i++)
			model.addElement("Element " + i);
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}
	
	public void resetList(ArrayList<String> arg) {
		model.clear();
		for (String player : arg) {
			if(player.compareTo(ClientSocketSingleton.getInstance().getMessager().getUsername()) != 0) {
				model.addElement(player);
			}
		}
	}
	
}
