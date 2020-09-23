package sugangShincheong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;
import javax.swing.table.DefaultTableModel;

import control.CSelection;

public class PDirectory extends JTable {
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	private SelectionListner listSelectionHandler;
	private String title;
	public CSelection cSelection;
	public PContentPanel pContentPanel;
	public PSelection pSelection;
	public PDirectory(String title, CSelection cSelection, PSelection pSelection) {
		this.title = title;
		this.pSelection = pSelection;
		this.cSelection = cSelection;
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listSelectionHandler = new SelectionListner();
		this.getSelectionModel().addListSelectionListener(listSelectionHandler);
	}
	
	public void addContent(Vector<String> vec) {
		this.tableModel = new DefaultTableModel();
		this.tableModel.addColumn(title, vec.toArray());
		this.setModel(this.tableModel);
	}
	
	public class SelectionListner implements ListSelectionListener{
		private String campus = "서울";
		private String college = "인문대학";
		private int temp;
		@Override
		public void valueChanged(ListSelectionEvent event) {
			// TODO Auto-generated method stub
			if(!event.getValueIsAdjusting()) {
				String str1 = event.getSource().toString();
				String[] arr1 = str1.split("=");
				String[] arr2 = arr1[1].split("");
				if(!arr2[1].equals("}")) {
					this.temp = Integer.parseInt(arr2[1]);
				}
				if(title=="캠퍼스") {
					this.campus = cSelection.CSelection(title).getIndex(this.temp);
					Vector<String> vec = cSelection.CSelection(campus).getData();
					this.college = cSelection.CSelection(campus).getIndex(this.temp);
					Vector<String> vec2 = cSelection.CSelection(college).getData();
					pSelection.setCollege(vec);
					pSelection.setHakgwa(vec2);
//					revalidate();
				}
				else if(title=="대학") {
					this.college = cSelection.CSelection(campus).getIndex(this.temp);
					Vector<String> vec = cSelection.CSelection(college).getData();
					pSelection.setHakgwa(vec);
				}
			}
		}
	}
}
