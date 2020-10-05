package mainFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.Constants;

public class PEditMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	public PEditMenu() {
		// set attribute
		this.setText(Constants.EMenuBar.EDIT.getText());

		for(Constants.EEDITMenu eEditMenu : Constants.EEDITMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eEditMenu.getText());
			this.add(menuItem);
		}

	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
