package sugangShincheong;

import java.io.Serializable;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import valueObject.VGangjwa;

public class PResult extends JTable implements Serializable{
	private static final long serialVersionUID = 1L;

	public DefaultTableModel tableModel;
	public Vector<VGangjwa> vGangjwas;
	
	public PResult() {
		Vector<String> header = new Vector<String>();
		header.addElement("���¹�ȣ");
		header.addElement("���¸�");
		
		this.tableModel = new DefaultTableModel(header,0);
		this.setModel(this.tableModel);
		
		this.vGangjwas = new Vector<VGangjwa>();
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	public void setGangjwas(Vector<VGangjwa> vec) {
		this.vGangjwas = vec;
		updateTableData();
	}
	
	public Vector<VGangjwa> removeDuplicated(Vector<VGangjwa> vSelectedGangjwas) {
		for(int index=vSelectedGangjwas.size()-1;index>=0;index--) {
			for(VGangjwa vGangjwa: this.vGangjwas) {
				if(vSelectedGangjwas.get(index).getId().equals(vGangjwa.getId())){
					vSelectedGangjwas.remove(index);
					break;
				}
			}
		}
		return vSelectedGangjwas;
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
		this.vGangjwas.addAll(vSelectedGangjwas);
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


}
