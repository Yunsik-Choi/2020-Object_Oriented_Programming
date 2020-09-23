package sugangShincheong;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PSelection extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
//	private PGangjwa pGangjwa;
	
	public PSelection() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory("캠퍼스");
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory("대학");
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory("학과");
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
		
	}
}
