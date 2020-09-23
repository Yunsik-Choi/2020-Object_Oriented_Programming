package valueObject;

import java.util.Vector;

public class VSelection {

	private Vector<String> data;
	public VSelection(Vector<String> data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	
	public Vector<String> getData() {
		return data;
	}
	
	public String getIndex(int index) {
		return data.elementAt(index);
	}

}
