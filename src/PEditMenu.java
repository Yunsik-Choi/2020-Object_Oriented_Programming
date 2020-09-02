import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PEditMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	public PEditMenu() {
		// set attribute
		this.setText(Constants.EMenuBar.EDIT.getText());

		for(Constants.EEditMenu eEditMenu : Constants.EEditMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eEditMenu.getText());
			this.add(menuItem);
		}

	}

}
