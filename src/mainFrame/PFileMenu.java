package mainFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.Constants;

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

	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
