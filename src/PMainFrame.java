import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private PMenuBar pMenuBar;
	private PToolBar pToolBar;
	private PMainPanel pMainPanel;
	//constructor
	public PMainFrame() {
		this.setSize(Constants.EMainFrame.WIDTH.getSize(),Constants.EMainFrame.HEIGHT.getSize());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pMenuBar = new PMenuBar();
		this.setJMenuBar(this.pMenuBar);
		
		this.setLayout(new GridLayout(2,1));
		
		this.pToolBar = new PToolBar();
		this.add(this.pToolBar);
		
		this.pMainPanel = new PMainPanel();
		this.add(this.pMainPanel);
	}
}
