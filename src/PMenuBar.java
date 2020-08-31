import javax.swing.JMenuBar;

public class PMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private PFileMenu pFileMenu;
	
	public PMenuBar() {
		// create and register components
		this.pFileMenu = new PFileMenu();
		this.add(pFileMenu);
	}

}
