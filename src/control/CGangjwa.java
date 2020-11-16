package control;

import java.util.Vector;

import model.DataAcessObject;
import model.MDirectory;
import model.MGangjwa;
import model.MModel;
import valueObject.VDirectory;
import valueObject.VGangjwa;

public class CGangjwa {

	public CGangjwa() {
		
	}

	public Vector<VGangjwa> getData(String fileName) {

		DataAcessObject dataAcessObject = new DataAcessObject();
		Vector<MModel> mModels =  dataAcessObject.getModels(fileName,MGangjwa.class);
		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
		for(MModel mModel : mModels) {
			MGangjwa mGangjwa = (MGangjwa) mModel;
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
