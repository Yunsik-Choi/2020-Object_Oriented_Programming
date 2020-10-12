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
		Vector<MGangjwa> mGangjwas =  dataAcessObject.getGangjwas(fileName);
		
		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
		for(MGangjwa mGangjwa : mGangjwas) {
			VGangjwa vGangjwa = new VGangjwa(
				mGangjwa.getId(), 
				mGangjwa.getName(),
				mGangjwa.getLecturer(),
				mGangjwa.getCredit()
				,mGangjwa.getTime()
			);
			vGangjwas.add(vGangjwa);
		}
		return vGangjwas;
	}
}
