package control;

import java.util.Vector;

import model.DataAcessObject;
import model.MDirectory;
import model.MModel;
import valueObject.VDirectory;

public class CDirectory {

	public CDirectory() {
		
	}

	public Vector<VDirectory> getData(String fileName) {
		DataAcessObject dataAcessObject = new DataAcessObject();
		Vector<MModel> mModels =  dataAcessObject.getModels(fileName,MDirectory.class);
		
		Vector<VDirectory> vDirectories = new Vector<VDirectory>();
		for(MModel mModel : mModels) {
			MDirectory mDirectory = (MDirectory) mModel;
			VDirectory vDirectory = new VDirectory(
				mDirectory.getName(), 
				mDirectory.getFileName()
			);
			vDirectories.add(vDirectory);
		}
		return vDirectories;
	}
}
