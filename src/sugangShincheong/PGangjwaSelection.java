package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import control.CDirectory;
import control.CGangjwa;
import sugangShincheong.PSelection.ListSelectionHandler;
import valueObject.VDirectory;
import valueObject.VGangjwa;

public class PGangjwaSelection extends JTable {
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel tableModel;
	private Vector<VGangjwa> vGangjwas;
	private Vector<VGangjwa> selectedGangjwas;
	private CGangjwa cGangjwa;
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
	}
	
	public void initialize(String fileName) {
		this.getData(fileName);
		ListSelectionHandler listSelectionHandler = new ListSelectionHandler();
		this.getSelectionModel().addListSelectionListener(listSelectionHandler);
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}
	
	public Vector<VGangjwa> getSelectedGangjwas() {
		return this.selectedGangjwas;
	}
	
	public void update(String fileName) {
		this.getData(fileName);
	}

	public String getData(String fileName) {
		this.cGangjwa = new CGangjwa();
		this.vGangjwas = cGangjwa.getData(fileName);
		this.tableModel.setRowCount(0);
		for (VGangjwa vGangjwa: this.vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getId());
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getLecturer());
			row.add(vGangjwa.getCredit());
			this.tableModel.addRow(row);
		}
		if(this.vGangjwas.size()>0) {
		}
		return null;
	}
	
	public class ListSelectionHandler implements ListSelectionListener{
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if(!e.getValueIsAdjusting()) {
				int[] selectedRows = getSelectedRows();
				Vector<VGangjwa> gangjwas = new Vector<VGangjwa>();
				for(int i: selectedRows) {
					gangjwas.add(vGangjwas.get(i));
				}
				selectedGangjwas = gangjwas;
			}
		}
		
	}

}
