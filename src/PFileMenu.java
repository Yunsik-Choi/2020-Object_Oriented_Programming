import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	public PFileMenu() {
		// set attribute
		this.setText(Constants.EMenuBar.FILE.getText());
		
		for(Constants.EFileMenu eFileMenu: Constants.EFileMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eFileMenu.getText());
			this.add(menuItem);
		}
	}

}
