package sugangShincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CDirectory;
import sugangShincheong.PSelection.ListSelectionHandler;
import valueObject.VDirectory;

public class PHakgwaSelection extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pHakgwa;
	
	private String fileName;
	private String GangjwaName = "englishYG";
	
	
	public PHakgwaSelection(ListSelectionHandler listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.fileName = "root";
		
		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		this.pCampus = new PDirectory("캠퍼스",listSelectionHandler);
		scrollpane.setViewportView(this.pCampus);
		this.add(scrollpane);
		fileName = this.pCampus.getData(fileName);
		
		scrollpane = new JScrollPane();
		this.pCollege = new PDirectory("대학",listSelectionHandler);
		scrollpane.setViewportView(this.pCollege);
		this.add(scrollpane);
		fileName = this.pCollege.getData(fileName);
		
		scrollpane = new JScrollPane();
		this.pHakgwa = new PDirectory("학과",listSelectionHandler);
		scrollpane.setViewportView(this.pHakgwa);
		this.add(scrollpane);
		fileName = this.pHakgwa.getData(fileName);
		
	}

	public void update(Object source, Vector<String> searchDirectory) {
		String s = source.toString();
		String[] temp = s.split(" ");
		String[] arr = temp[2].split("");
		int selectNum;
		if(!arr[2].equals("}")) {
			selectNum = Integer.parseInt(arr[2]);
		}else {
			selectNum = 0;
		}
		if(temp[1].equals(searchDirectory.get(0))) {
			String file = this.pCampus.cDirectory.getData("root").get(selectNum).getFileName();
			this.pCollege.setData(file);
			String file2 = this.pCollege.cDirectory.getData(file).get(0).getFileName();
			this.pHakgwa.setData(file2);
		} else if(temp[1].equals(searchDirectory.get(1))) {
			String file2 = this.pCollege.vDirectories.get(selectNum).getFileName();
			this.pHakgwa.setData(file2);
		} else if(temp[1].equals(searchDirectory.get(2))) {
			String file3 = this.pHakgwa.vDirectories.get(selectNum).getFileName();
			this.GangjwaName = file3;
		}
	}
	
	public void setDefault() {
		String file = this.pCampus.cDirectory.getData("root").get(0).getFileName();
		this.pCollege.setData(file);
		String file2 = this.pCollege.cDirectory.getData(file).get(0).getFileName();
		this.pHakgwa.setData(file2);
		String file3 = this.pHakgwa.vDirectories.get(0).getFileName();
		this.GangjwaName = file3;
	}
	
	public class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;

		private DefaultTableModel tableModel;
		private CDirectory cDirectory;
		private Vector<VDirectory> vDirectories;
		
		public PDirectory(String title, ListSelectionHandler listSelectionHandler) {
			//attributes
			this.getSelectionModel().addListSelectionListener(listSelectionHandler);
			
			//data model
			Vector<String> header = new Vector<String>();
			header.addElement(title);
			this.tableModel = new DefaultTableModel(header,0);
			this.setModel(tableModel);
		}

		public String getData(String fileName) {
			this.cDirectory = new CDirectory();
			this.vDirectories = cDirectory.getData(fileName);
			for (VDirectory vDirectory: vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);
			}
			if(vDirectories.size()>0) {
				this.getSelectionModel().addSelectionInterval(0, 0);
				return vDirectories.get(0).getFileName();
			}
			return null;
		}
		
		public void setData(String fileName) {
			this.tableModel.setRowCount(0);
			getData(fileName);
		}
	}
	public String getFileName() {
		return GangjwaName;
	}

}
