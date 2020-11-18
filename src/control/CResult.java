package control;

import java.util.Vector;

import model.DataAcessObject;
import model.MGangjwa;
import model.MModel;
import valueObject.VGangjwa;

public class CResult {

	public CResult() {
		
	}
	public void save(String fileName, Vector<VGangjwa> vGangjwas) {
		DataAcessObject dataAccessObject = new DataAcessObject();
		dataAccessObject.saveResult(fileName,vGangjwas);
	}
	public Vector<VGangjwa> get(String fileName) {
		DataAcessObject dataAccessObject = new DataAcessObject();
		Vector<MModel> mModels = dataAccessObject.getModels(fileName, MGangjwa.class);
		
		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
		for(MModel mModel : mModels) {
			MGangjwa mGangjwa = (MGangjwa) mModel;
			VGangjwa vGangjwa = new VGangjwa(
					mGangjwa.getId(),
					mGangjwa.getName(), 
					mGangjwa.getLecturer(), 
					mGangjwa.getCredit(),
					mGangjwa.getTime()
			);
			vGangjwas.add(vGangjwa);
		}
		
		return vGangjwas;
	}

}
