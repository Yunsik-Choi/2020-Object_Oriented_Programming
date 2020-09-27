package control;

import java.util.Vector;

import model.DataAcessObject;
import model.MHakgwa;
import valueObject.VHakgwa;

public class CHakgwaSelection {
	private MHakgwa mHakgwa;
	private DataAcessObject dao;
	
	public CHakgwaSelection setHakgwaSelection(String fname) {
		this.dao = new DataAcessObject();
		this.mHakgwa = dao.getHakgwa(fname);
		return this;
	}
	
	public String getFile(int index){
		String fname = mHakgwa.getIndex(index);
		return fname;
	}
	
	public Vector<String> getTitle(){
		Vector<String> vecTitle = mHakgwa.getTitle();
		return vecTitle ;
		
	}
}
