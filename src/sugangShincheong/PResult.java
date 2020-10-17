package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sugangShincheong.PGangjwaSelection.ListSelectionHandler;
import valueObject.VGangjwa;

public class PResult extends JTable {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private Vector<VGangjwa> row = new Vector<VGangjwa>();
	private int[] selectedRows;
	
	public PResult(String string) {
		String[] header = {string};
		this.tableModel = new DefaultTableModel(header,0);
		this.setModel(tableModel);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		ListSelectionHandler listSelectionHandler = new ListSelectionHandler();
		this.getSelectionModel().addListSelectionListener(listSelectionHandler);
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}

	public void addGangjwas(Vector<VGangjwa> vGangjwas) {
		// TODO Auto-generated method stub
		if(vGangjwas!=null) {
			for(VGangjwa i : vGangjwas) {
				if(!this.row.contains(i)) {
					row.add(i);
					String[] temp = {i.getId() + "  "+i.getName()};
					this.tableModel.addRow(temp);
				}
				
			}
		}

	}

	public Vector<VGangjwa> removeGangjwa() {
		// TODO Auto-generated method stub
		if(this.selectedRows!=null) {
			Vector<VGangjwa> remove = new Vector<VGangjwa>();
			for(int i : selectedRows) {
				remove.add(row.get(i));
			}
			int a = 0;
			for(int i: selectedRows) {
				System.out.println(i);
				this.tableModel.removeRow(i-a);
				this.row.remove(i-a);
				a++;
			}
			this.selectedRows = null;
			return remove;
		}
		return null;
	}
	
	public class ListSelectionHandler implements ListSelectionListener{
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()) {
				selectedRows = getSelectedRows();
			}
		}
		
	}
}
