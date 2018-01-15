package snippet;

public class Snippet {
	addWindowListener(new WindowAdapter()
		        {
		            public void windowClosing(WindowEvent e)
		            {
		                ClientSocketSingleton.getInstance().getMessager().sendMessage("###:: me");
		                e.getWindow().dispose();
		            }
		        });
}

