package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CResult;
import valueObject.VGangjwa;
import valueObject.VUser;

public class PResult extends JTable {
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	private Vector<VGangjwa> vGangjwas;
	
	public PResult() {
		Vector<String> header = new Vector<String>();
		header.addElement("°­ÁÂ¹øÈ£");
		header.addElement("°­ÁÂ¸í");
		
		this.tableModel = new DefaultTableModel(header,0);
		this.setModel(this.tableModel);
		
		this.vGangjwas = new Vector<VGangjwa>();
	}

	public void initialize(Vector<VGangjwa> vector) {
		// TODO Auto-generated method stub
		this.vGangjwas = vector;
		updateTableData();
		
	}
	private void moveSelectedGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		for(VGangjwa vSelectedGangjwa : vSelectedGangjwas) {
			boolean found = false;
			for(VGangjwa vGangjwa:this.vGangjwas) {
				if(vSelectedGangjwa.getId().equals(vGangjwa.getId())) {
					found = true;
					break;
				}
			}
			if(!found) {
				this.vGangjwas.add(vSelectedGangjwa);
			}
		}
	}

	private void updateTableData() {
		this.tableModel.setRowCount(0);
		for (VGangjwa vGangjwa: this.vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getId());
			row.add(vGangjwa.getName());
			this.tableModel.addRow(row);
		}
		if(this.vGangjwas.size()>0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
		}
	}
	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		this.moveSelectedGangjwas(vSelectedGangjwas);
		this.updateTableData();
	}

	public Vector<VGangjwa> removeGangjwa() {
		int[] indices = this.getSelectedRows();
		Vector<VGangjwa> vRemovedGangjwas = new Vector<VGangjwa>();
		for(int i=indices.length-1;i>=0;i--) {
			VGangjwa vRemoveGangjwa = this.vGangjwas.remove(indices[i]);
			vRemovedGangjwas.add(vRemoveGangjwa);
		}
		this.updateTableData();
		return vRemovedGangjwas;
	}

	public Vector<VGangjwa> getGangjwas() {
		// TODO Auto-generated method stub
		return this.vGangjwas;
	}
}
