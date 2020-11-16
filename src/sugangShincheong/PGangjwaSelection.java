package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPGangjwaSelection;
import control.CGangjwa;
import valueObject.VGangjwa;

public class PGangjwaSelection extends JTable {
	private static final long serialVersionUID = 1L;
	private CGangjwa cGangjwa;
	private DefaultTableModel tableModel;
	private Vector<VGangjwa> vGangjwas;
	
	private PResult pMridamgi;
	private PResult pSincheong;
	
	public PGangjwaSelection() {
		//data model
		Vector<String> header = new Vector<String>();
		for(EPGangjwaSelection ePGangjwaSelection: EPGangjwaSelection.values()) {
			header.addElement(ePGangjwaSelection.getText());
		}

		this.tableModel = new DefaultTableModel(header,0);
		this.setModel(tableModel);
	}
	
	public void initialize(String fileName, PResult pMiridamgi, PResult pSincheong) {
		this.pMridamgi = pMiridamgi;
		this.pSincheong = pSincheong;
		this.update(fileName);
	}
	

	public void removeDuplicated(Vector<VGangjwa> vSelectedGangjwas) {
		for(int index=this.vGangjwas.size()-1;index>=0;index--) {
			for(VGangjwa vGangjwa: vSelectedGangjwas) {
				if(this.vGangjwas.get(index).getId().equals(vGangjwa.getId())){
					this.vGangjwas.remove(index);
					break;
				}
			}
		}
	}
	
	private void updateTableContents() {
		this.tableModel.setRowCount(0);
		for (VGangjwa vGangjwa: this.vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getId());
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getLecturer());
			row.add(vGangjwa.getCredit());
			row.add(vGangjwa.getTime());
			this.tableModel.addRow(row);
		}
		if(this.vGangjwas.size()>0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
		}
	}
	
	public void update(String fileName) {
		this.cGangjwa = new CGangjwa();
		this.vGangjwas = this.cGangjwa.getData(fileName);
		
		this.removeDuplicated(this.pMridamgi.getGangjwas());
		this.removeDuplicated(this.pSincheong.getGangjwas());
		this.updateTableContents();
	}
	public Vector<VGangjwa> removeSelectedGangjwas(){
		int[] indices = this.getSelectedRows();
		Vector<VGangjwa> vRemovedGangjwas = new Vector<VGangjwa>();
		for(int i=indices.length-1;i>=0;i--) {
			VGangjwa vRemoveGangjwa = this.vGangjwas.remove(indices[i]);
			vRemovedGangjwas.add(vRemoveGangjwa);
		}
		this.updateTableContents();
		return vRemovedGangjwas;
	}

	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		this.vGangjwas.addAll(vSelectedGangjwas);
		this.updateTableContents();
	}



}
