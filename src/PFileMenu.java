import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	public PFileMenu() {
		// set attribute
		this.setText(Constants.EMenuBar.FILE.getText());

		JMenuItem newItem = new JMenuItem(Constants.EFileMenu.NEW.getText());
		this.add(newItem);
	}

}
