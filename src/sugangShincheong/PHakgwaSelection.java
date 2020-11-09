package sugangShincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EConfiguration;
import constants.Constants.EDirectory;
import control.CDirectory;
import valueObject.VDirectory;

public class PHakgwaSelection extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private String fileName;
	
	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;

	public PHakgwaSelection(ListSelectionListener listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory(EDirectory.campus.getText(),listSelectionHandler);
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory(EDirectory.college.getText(),listSelectionHandler);
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory(EDirectory.hakgwa.getText(),listSelectionHandler);
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
	}
	
	public void initialize() {
		this.fileName = EConfiguration.rootFileName.getText();
		this.fileName = this.pCampus.initialize(this.fileName);
		this.fileName = this.pCollege.initialize(this.fileName);
		this.fileName = this.pHakgwa.initialize(this.fileName);
	}
	public String getFileName() {
		return this.fileName;
	}

	public String update(Object source) {
		if(source.equals(this.pCampus.getSelectionModel())) {
			int selectedRowIndex = this.pCampus.getSelectedRow();
			this.fileName = this.pCampus.getSelectedFileName();
			this.fileName = this.pCollege.getData(this.fileName);
			this.fileName = this.pHakgwa.getData(this.fileName);
		} else if(source.equals(this.pCollege.getSelectionModel())) {
			int selectedRowIndex = this.pCollege.getSelectedRow();
			this.fileName = this.pCollege.getSelectedFileName();
			this.fileName = this.pHakgwa.getData(this.fileName);
		} else if(source.equals(this.pHakgwa.getSelectionModel())) {
			this.fileName = this.pHakgwa.getSelectedFileName();
		}
		return this.fileName;
	}
	public class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;

		private CDirectory cDirectory;
		Vector<VDirectory> vDirectories;
		
		private DefaultTableModel tableModel;
		
		private ListSelectionListener listSelectionHandler;
		
		
		public String initialize(String fileName) {
			return this.getData(fileName);
		}
		
		public PDirectory(String title, ListSelectionListener listSelectionHandler) {
			//attributes
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.listSelectionHandler = listSelectionHandler;
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			
			//data model
			Vector<String> header = new Vector<String>();
			header.addElement(title);
			this.tableModel = new DefaultTableModel(header,0);
			this.setModel(tableModel);
		}

		public String getSelectedFileName() {
			int selectedIndex = this.getSelectedRow();
			String selectedFileName = this.vDirectories.get(selectedIndex).getFileName();
			return selectedFileName;
		}

		public String getData(String fileName) {
			this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
			this.cDirectory = new CDirectory();
			this.vDirectories = cDirectory.getData(fileName);
			this.tableModel.setRowCount(0);
			for (VDirectory vDirectory: this.vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);
			}
			String selectedFileName = null;
			if(vDirectories.size()>0) {
				this.getSelectionModel().addSelectionInterval(0, 0);
				selectedFileName = this.vDirectories.get(0).getFileName();
			}
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			return selectedFileName;
		}
	}


}
