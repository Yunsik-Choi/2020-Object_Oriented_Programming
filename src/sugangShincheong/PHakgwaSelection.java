package sugangShincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CGangjwaSelection;
import control.CHakgwaSelection;

public class PHakgwaSelection extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
	
	private PSelection pSelection;
	private CHakgwaSelection cCampusSelection;
	private CHakgwaSelection cCollegeSelection;
	private CHakgwaSelection cHakgwaSelection;
	
	public PHakgwaSelection(PSelection pSelection) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.cCampusSelection = new CHakgwaSelection();
		this.cCollegeSelection = new CHakgwaSelection();
		this.cHakgwaSelection = new CHakgwaSelection();
		this.pSelection = pSelection;
		
		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory("캠퍼스",this);
		this.pCampus.addContent(cCampusSelection.setHakgwaSelection("root").getTitle());
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory("대학",this);
		this.pCollege.addContent(cCollegeSelection.setHakgwaSelection("seoul").getTitle());
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory("학과",this);
		this.pHakgwa.addContent(cHakgwaSelection.setHakgwaSelection("generalS").getTitle());
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
		

	}

	
	public void setHakgwa(int i) {
		this.pHakgwa.addContent(cHakgwaSelection.setHakgwaSelection(cCollegeSelection.getFile(i)).getTitle());
	}

	public void setCollege(int i) {
		this.pCollege.addContent(cCollegeSelection.setHakgwaSelection(cCampusSelection.getFile(i)).getTitle());
	}
	
	public void setGangjwa(int i) {
		this.pSelection.setGangjwa(cHakgwaSelection.getFile(i));
	}
}
