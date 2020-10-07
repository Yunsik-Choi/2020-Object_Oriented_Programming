package control;

import java.util.Vector;

import model.DataAcessObject;
import model.MDirectory;
import valueObject.VDirectory;

public class CDirectory {

	public CDirectory() {
		
	}

	public Vector<VDirectory> getData(String fileName) {
		DataAcessObject dataAcessObject = new DataAcessObject();
		Vector<MDirectory> mDirectories =  dataAcessObject.getDirectories(fileName);
		
		Vector<VDirectory> vDirectories = new Vector<VDirectory>();
		for(MDirectory mDirectory : mDirectories) {
			VDirectory vDirectory = new VDirectory(
				mDirectory.getName(), 
				mDirectory.getFileName()
			);
			vDirectories.add(vDirectory);
		}
		return vDirectories;
	}
}
