package sugangShincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class PHakgwaSelection extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
	
	public PHakgwaSelection() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory("ķ�۽�");
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory("����");
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory("�а�");
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
		
	}
	
	public class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;

		public PDirectory(String title) {
			//attributes
			//data model
			Vector<String> header = new Vector<String>();
			header.addElement(title);
			DefaultTableModel tableModel = new DefaultTableModel(header,0);
			this.setModel(tableModel);
		}
	}
}
