package sugangShincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;
import javax.swing.table.DefaultTableModel;

import control.CGangjwaSelection;
import control.CHakgwaSelection;

public class PDirectory extends JTable {
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	private SelectionListner listSelectionListner;
	public PHakgwaSelection pHakgwaSelection;
	public PContentPanel pContentPanel;
	public PSelection pSelection;
	private String title;
	public PDirectory(String title, PHakgwaSelection pHakgwaSelection) {
		this.title = title;
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.pHakgwaSelection = pHakgwaSelection;
		Vector<String> header = new Vector<String>();
		header.addElement(title);
		this.listSelectionListner = new SelectionListner();
		this.getSelectionModel().addListSelectionListener(listSelectionListner);
	}
	
	public void addContent(Vector<String> vec) {
		this.tableModel = new DefaultTableModel();
		this.tableModel.addColumn(title, vec.toArray());
		this.setModel(this.tableModel);
	}
	
	public class SelectionListner implements ListSelectionListener{
		private String campus = "seoul";
//		private String college = "generalS";
//		private int temp;
		
		@Override
		public void valueChanged(ListSelectionEvent event) {
			// TODO Auto-generated method stub
			if(!event.getValueIsAdjusting()) {
				String str = event.getSource().toString();
				String[] temp = str.split("=");
				String[] arr = temp[1].split("");
				if(arr[1].equals("}")) {
					arr[1] = "0";
				}
				int selectNum = Integer.parseInt(arr[1]);
				if(title=="캠퍼스") {
					pHakgwaSelection.setCollege(selectNum);
					pHakgwaSelection.setHakgwa(0);
				}
				else if(title=="대학") {
					pHakgwaSelection.setHakgwa(selectNum);
				}
				else if(title=="학과") {
					pHakgwaSelection.setGangjwa(selectNum);
				}
			}
		}
		
	}
}
