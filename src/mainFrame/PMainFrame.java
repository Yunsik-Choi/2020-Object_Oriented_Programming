package mainFrame;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import constants.Constants;
import sugangShincheong.PSugangShincheongPanel;
import valueObject.VUser;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private PMenuBar pMenuBar;
	private PToolBar pToolBar;
	private PSugangShincheongPanel pMainPanel;
	//constructor
	public PMainFrame(VUser vUser) {
		// set attributes
		this.setSize(Constants.EMainFrame.WIDTH.getSize(),Constants.EMainFrame.HEIGHT.getSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//layout
		this.setLayout(new BorderLayout());
		
		// components
		this.pMenuBar = new PMenuBar();
		this.setJMenuBar(this.pMenuBar);
		
		this.pToolBar = new PToolBar();
		this.add(this.pToolBar,BorderLayout.NORTH);
		
		this.pMainPanel = new PSugangShincheongPanel(vUser);
		this.add(this.pMainPanel,BorderLayout.CENTER);
		
	}
}
