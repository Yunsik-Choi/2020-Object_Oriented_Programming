package sugangShincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPResult;
import control.CResult;
import valueObject.VGangjwa;

public class PResult extends PGangjwaContainer {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel tableModel;
	private Vector<VGangjwa> vGangjwas;
	
	public PResult() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.table = new JTable();
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(this.table);
		this.add(scrollpane);
		
		//data model
		Vector<String> header = new Vector<String>();
		for(EPResult ePResult: EPResult.values()) {
			header.addElement(ePResult.getText());
		}
		
		this.tableModel = new DefaultTableModel(header,0);
		this.table.setModel(this.tableModel);
		
		this.vGangjwas = new Vector<VGangjwa>();
	}

	public void initialize(String fileName) {
		CResult cResult = new CResult();
		this.vGangjwas = cResult.get(fileName);
		this.updateTableData();
	}
	
	public Vector<VGangjwa> getGangjwas() {
		return this.vGangjwas;
	}
	
	public void save(String fileName) {
		CResult cResult = new CResult();
		cResult.save(fileName,this.vGangjwas);
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
			this.table.getSelectionModel().addSelectionInterval(0, 0);
		}
	}
	
	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		this.vGangjwas.addAll(vSelectedGangjwas);
		this.updateTableData();
	}

	public Vector<VGangjwa> removeSelectedGangjwas() {
		int[] indices = this.table.getSelectedRows();
		Vector<VGangjwa> vRemovedGangjwas = new Vector<VGangjwa>();
		for(int i=indices.length-1;i>=0;i--) {
			VGangjwa vRemoveGangjwa = this.vGangjwas.remove(indices[i]);
			vRemovedGangjwas.add(vRemoveGangjwa);
		}
		this.updateTableData();
		return vRemovedGangjwas;
	}
}
