package control;

import java.util.Vector;

import model.DataAcessObject;
import valueObject.VGangjwa;
import valueObject.VUser;

public class CResult {
	
	private VUser vUser;
	DataAcessObject dataAcessObject;
	public CResult(VUser vUser) {
		// TODO Auto-generated constructor stub
		this.vUser = vUser;
		this.dataAcessObject = new DataAcessObject();
	}

	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		dataAcessObject.addGangjwas(vUser,vSelectedGangjwas);
		
	}

	public void removeGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		// TODO Auto-generated method stub
		if(dataAcessObject!=null) {
			this.dataAcessObject.removeGangjwas(vUser,vSelectedGangjwas);
		}
	}
	
	public Vector<VGangjwa> getGangjwas(VUser vUser){
		Vector<VGangjwa> vec = this.dataAcessObject.getPreserveGangjwas(vUser.getUserId());
		return vec;
	}

}
