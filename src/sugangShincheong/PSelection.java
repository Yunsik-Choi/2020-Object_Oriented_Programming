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
		this.pCampus = new PDirectory("ķ�۽�",this.cSelection,this);
		this.pCampus.addContent(cSelection.CSelection("ķ�۽�").getData());
		scrollpane.setViewportView(this.pCampus);
		
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory("����", this.cSelection,this);
		this.pCollege.addContent(cSelection.CSelection("����").getData());
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory("�а�", this.cSelection,this);
		this.pHakgwa.addContent(cSelection.CSelection("�ι�����").getData());
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
