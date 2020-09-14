package sugangShincheong;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PHeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel welcomeLabel;
	public PHeaderPanel() {

	}
	
	public void setHeaderLabel(String text) {
		this.welcomeLabel = new JLabel(text+"¥‘ æ»≥Á«œººø‰");
		this.add(this.welcomeLabel);
	}
}
