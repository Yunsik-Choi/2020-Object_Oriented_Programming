package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;
import javax.swing.table.DefaultTableModel;

public class PDirectory extends JTable {
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	public PDirectory(String title) {
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Vector<String> header = new Vector<String>();
		header.addElement(title);
		
		this.tableModel = new DefaultTableModel(header,0);
		this.setModel(this.tableModel);
//		this.getSelectionModel().addListSelectionListener(ListSelectionHandler);
	}
}
