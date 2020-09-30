package control;

import java.util.Vector;

import model.DataAcessObject;
import model.MDirectory;
import model.MGangjwa;
import valueObject.VDirectory;
import valueObject.VGangjwa;

public class CGangjwa {

	public CGangjwa() {
			
	}

	public Vector<VGangjwa> getData(String fileName) {
		DataAcessObject dataAcessObject = new DataAcessObject();
		MGangjwa mGangjwa =  dataAcessObject.getGangjwas(fileName);
		
		Vector<VGangjwa> vGangjwas  = new Vector<VGangjwa>();
		for(int i=0;i<=mGangjwa.getName().indexOf(mGangjwa.getName().lastElement());i++) {
			VGangjwa vGangjwa = new VGangjwa(
				mGangjwa.getNum().get(i), 
				mGangjwa.getName().get(i), 
				mGangjwa.getPro().get(i), 
				mGangjwa.getTime().get(i)
			);
			vGangjwas.add(vGangjwa);
		}
		return vGangjwas;
	}
}
