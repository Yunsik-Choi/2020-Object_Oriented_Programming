package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CDirectory;
import sugangShincheong.PSelection.ListSelectionHandler;
import valueObject.VDirectory;

public class PGangjwaSelection extends JTable {
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel tableModel;
	private Vector<VGangjwa> vGangjwas;
	
	public PGangjwaSelection() {
		//data model
		Vector<String> header = new Vector<String>();
		header.addElement("���¹�ȣ");
		header.addElement("���¸�");
		header.addElement("��米��");
		header.addElement("�ð�");

		DefaultTableModel tableModel = new DefaultTableModel(header,0);
		this.setModel(tableModel);
	}
	
	public String initialize(String fileName) {
	}
	

	public Vector<VGangjwa> getSelectedGangjwas() {
		return null;
	}
	
	public void update(String fileName) {
	}

	public String getData(String fileName) {
		CGangjwa cGangjwa = new CGangjwa();
		this.vGangjwas = cGangjwa.getData(fileName);
		this.tableModel.setRowCount(0);
		for (VGangjwa vGangjwa: this.vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getName());
			this.tableModel.addRow(row);
		}
		String selectedFileName = null;
		if(vDirectories.size()>0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
			selectedFileName = this.vDirectories.get(0).getFileName();
		}
		return selectedFileName;
	}


}
