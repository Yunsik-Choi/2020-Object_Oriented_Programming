package sugangShincheong;
import javax.swing.JLabel;
import javax.swing.JPanel;

import valueObject.VUser;

public class PHeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel welcomeLabel;
	public PHeaderPanel(VUser vUser) {
		this.welcomeLabel = new JLabel(vUser.getName()+"¥‘ æ»≥Á«œººø‰");
		this.add(this.welcomeLabel);
	}
}
