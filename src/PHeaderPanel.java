import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PHeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel welcomeLabel;
	private PLoginDialog pLoginDialog;
	private String userName;
	public PHeaderPanel() {
	}
	
	public void setUserName(String name) {
		this.userName = name;
		this.welcomeLabel = new JLabel(userName+"¥‘ æ»≥Á«œººø‰");
		this.add(this.welcomeLabel);
	}
}
