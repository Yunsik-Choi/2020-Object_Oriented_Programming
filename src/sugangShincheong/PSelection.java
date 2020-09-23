package sugangShincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.CSelection;

public class PSelection extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
//	private PGangjwa pGangjwa;
	
	private CSelection cSelection;
	
	public PSelection() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.cSelection = new CSelection();
		
		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory("캠퍼스",this.cSelection,this);
		this.pCampus.addContent(cSelection.CSelection("캠퍼스").getData());
		scrollpane.setViewportView(this.pCampus);
		
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory("대학", this.cSelection,this);
		this.pCollege.addContent(cSelection.CSelection("서울").getData());
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory("학과", this.cSelection,this);
		this.pHakgwa.addContent(cSelection.CSelection("인문대학").getData());
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
		
	}
	
	public void setCollege(Vector<String> vec) {
		this.pCollege.addContent(vec);
		
	}
	public void setHakgwa(Vector<String> vec) {
		this.pHakgwa.addContent(vec);
	}
}
