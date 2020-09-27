package control;

import java.util.Vector;

import model.DataAcessObject;
import model.MGangjwa;
import model.MHakgwa;
import valueObject.VGangjwa;

public class CGangjwaSelection {
	private MGangjwa mGangjwa;
	private DataAcessObject dao;
	
	public Vector<VGangjwa> cGangjwaSelection(String fname) {
		this.dao = new DataAcessObject();
		this.mGangjwa = dao.getGangjwa(fname);
		return this.mGangjwa.getGangjwa();
	}
	
}
