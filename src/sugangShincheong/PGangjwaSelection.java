package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PGangjwaSelection extends JTable {
	private static final long serialVersionUID = 1L;
	
	public PGangjwaSelection() {
		//data model
		Vector<String> header = new Vector<String>();
		header.addElement("���¹�ȣ");
		header.addElement("���¸�");
		header.addElement("��米��");
		header.addElement("�ð�");

		DefaultTableModel tableModel = new DefaultTableModel(header,0);
		this.setModel(tableModel);
	}

	public void initialize() {
		
	}
}
