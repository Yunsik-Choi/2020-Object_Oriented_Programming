package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CGangjwaSelection;
import valueObject.VGangjwa;

public class PGangjwaSelection extends JTable {
	private static final long serialVersionUID = 1L;
	
	private CGangjwaSelection cGangjwa = new CGangjwaSelection();
	private Vector<VGangjwa> gangjwaList;
	private DefaultTableModel tableModel;
	public PGangjwaSelection() {
		//data model
		Vector<String> header = new Vector<String>();
		header.addElement("강좌번호");
		header.addElement("강좌명");
		header.addElement("담당교수");
		header.addElement("학점");
		header.addElement("시간");
		this.tableModel = new DefaultTableModel(header,0);
		this.setModel(tableModel);
		setGangjwa("englishYG");
	}
	
	public class GDirectory extends JTable {
		public GDirectory() {
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
	}

	public void setGangjwa(String file) {
		this.tableModel.setRowCount(0);
		gangjwaList = this.cGangjwa.cGangjwaSelection(file);
		for(VGangjwa i : gangjwaList) {
			this.tableModel.addRow(i.getAll());
		}
	}
}
