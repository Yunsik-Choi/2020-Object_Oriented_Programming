import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class PToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;

	public PToolBar() {
		for(Constants.EToolButton btn : Constants.EToolButton.values()) {
			ImageIcon originIcon = new ImageIcon(btn.getSrc());
			Image originImg = originIcon.getImage();
			Image changedImg = originImg.getScaledInstance(30, 20, Image.SCALE_SMOOTH);
			ImageIcon Icon = new ImageIcon(changedImg);
			JButton button = new JButton(btn.getTitle(),Icon);
			this.add(button);
		}
	}
}
