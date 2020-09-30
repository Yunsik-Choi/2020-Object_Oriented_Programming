package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CGangjwa;
import valueObject.VDirectory;
import valueObject.VGangjwa;

public class PGangjwaSelection extends JTable {
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel tableModel;
	public PGangjwaSelection() {
		//data model
		Vector<String> header = new Vector<String>();
		header.addElement("강좌번호");
		header.addElement("강좌명");
		header.addElement("담당교수");
		header.addElement("시간");

		this.tableModel = new DefaultTableModel(header,0);
		this.setModel(tableModel);
	}

	public void update(String fileName) {
		this.tableModel.setRowCount(0);
		CGangjwa cGangjwa = new CGangjwa();
		Vector<VGangjwa> vGangjwas= cGangjwa.getData(fileName);
		for (VGangjwa vGangjwa: vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getNum());
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getPro());
			row.add(vGangjwa.getTime());
			this.tableModel.addRow(row);
		}
		if(vGangjwas.size()>0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
		}
	}
}
