package sugangShincheong;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PHeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel welcomeLabel;
	public PHeaderPanel() {
		this.welcomeLabel = new JLabel("�� �ȳ��ϼ���");
		this.add(this.welcomeLabel);
	}
}
