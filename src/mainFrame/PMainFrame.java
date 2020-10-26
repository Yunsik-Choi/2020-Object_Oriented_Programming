package mainFrame;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import constants.Constants;
import sugangShincheong.PSugangShincheongPanel;
import valueObject.VUser;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private WindowListener windowListner;
	
	private PMenuBar pMenuBar;
	private PToolBar pToolBar;
	private PSugangShincheongPanel pMainPanel;
	//constructor
	public PMainFrame() {
		// set attributes
		this.setSize(Constants.EMainFrame.WIDTH.getSize(),Constants.EMainFrame.HEIGHT.getSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.windowListner = new WindowsHandler();
		this.addWindowListener(this.windowListner);
		//layout
		this.setLayout(new BorderLayout());
		
		// components
		this.pMenuBar = new PMenuBar();
		this.setJMenuBar(this.pMenuBar);
		
		this.pToolBar = new PToolBar();
		this.add(this.pToolBar,BorderLayout.NORTH);
		
		this.pMainPanel = new PSugangShincheongPanel();
		this.add(this.pMainPanel,BorderLayout.CENTER);
	}
	
	public void initialize(VUser vUser) {
		this.pMenuBar.initialize();
		this.pToolBar.initialize();
		this.pMainPanel.initialize(vUser);
	}
	
	private void save() {
		this.pMainPanel.save();
	}
	private class WindowsHandler implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
		}
		@Override
		public void windowClosing(WindowEvent e) {
			save();
		}
		@Override
		public void windowClosed(WindowEvent e) {
		}
		@Override
		public void windowIconified(WindowEvent e) {
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
		}
		@Override
		public void windowActivated(WindowEvent e) {
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
		}
		
	}
}
	
