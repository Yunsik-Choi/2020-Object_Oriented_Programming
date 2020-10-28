package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CResult;
import valueObject.VGangjwa;

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

	public void initialize(String fileName) {
		CResult cResult = new CResult();
		this.vGangjwas = cResult.get(fileName);
		this.updateTableData();
	}
	public void save(String fileName) {
		CResult cResult = new CResult();
		cResult.save(fileName,this.vGangjwas);
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
