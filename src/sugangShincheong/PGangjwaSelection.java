package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CGangjwa;
import valueObject.VGangjwa;

public class PGangjwaSelection extends JTable {
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel tableModel;
	private Vector<VGangjwa> vGangjwas;
	
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
	
	public void initialize(String fileName, Vector<VGangjwa> miridamgiGangjwas, Vector<VGangjwa> sincehongGangjwas) {
		this.update(fileName,miridamgiGangjwas, sincehongGangjwas);
	}
	public Vector<VGangjwa> getGangjwas() {
		return this.vGangjwas;
	}
	
	public Vector<VGangjwa> getSelectedGangjwas() {
		Vector<VGangjwa> vSelectedGangjwas = new Vector<VGangjwa>();
		int[] indices = this.getSelectedRows();
		for(int index:indices) {
			vSelectedGangjwas.add(this.vGangjwas.get(index));
		}
		return vSelectedGangjwas;
	}
	
	
	private void getData(String fileName) {
		CGangjwa cGangjwa = new CGangjwa();
		this.vGangjwas = cGangjwa.getData(fileName);
	}

	private Vector<VGangjwa> removeDuplicated(Vector<VGangjwa> vSelectedGangjwas) {
		for(int index=this.vGangjwas.size()-1;index>=0;index--) {
			for(VGangjwa vGangjwa: vSelectedGangjwas) {
				if(this.vGangjwas.get(index).getId().equals(vGangjwa.getId())){
					this.vGangjwas.remove(index);
					break;
				}
			}
		}
		return vSelectedGangjwas;
	}
	
	private void updateTableContents() {
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
			this.getSelectionModel().addSelectionInterval(0, 0);
		}
	}
	
	public void update(String fileName, Vector<VGangjwa> miridamgiGangjwas, Vector<VGangjwa> sincehongGangjwas) {
		this.getData(fileName);
		this.removeDuplicated(miridamgiGangjwas);
		this.removeDuplicated(sincehongGangjwas);
		this.updateTableContents();
	}



}
