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
	private String fileName;
	
	public PGangjwaSelection() {
		//data model
		Vector<String> header = new Vector<String>();
		header.addElement(EPGangjwaSelection.gangjwaNo.getText());
		header.addElement(EPGangjwaSelection.gangjwaName.getText());
		header.addElement(EPGangjwaSelection.damdangGyosu.getText());
		header.addElement(EPGangjwaSelection.hakjeom.getText());
		header.addElement(EPGangjwaSelection.time.getText());

		this.tableModel = new DefaultTableModel(header,0);
		this.setModel(tableModel);
	}
	
	public void initialize(String fileName) {
		this.update(fileName);
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
		this.cGangjwa = new CGangjwa();
		this.vGangjwas = this.cGangjwa.getData(fileName);
	}
//	private CGangjwa getCGangjwa() {
//		return this.cGangjwa;
//	}

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
	
	public void updateTableContents() {
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
	
	public void update(String fileName) {
		this.fileName = fileName;
		this.getData(fileName);
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

	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas, String hakgwafileName) {
		Vector<VGangjwa> vTempGangjwas = new Vector<VGangjwa>();
		Vector<VGangjwa> origin = this.cGangjwa.getData(this.fileName);
		for(VGangjwa i: vSelectedGangjwas) {
			for(VGangjwa l : origin) {
				if(i.getId().equals(l.getId())) {
					vTempGangjwas.add(i);
				}
			}
		}
		this.vGangjwas.addAll(vTempGangjwas);
		this.updateTableContents();
	}



}
