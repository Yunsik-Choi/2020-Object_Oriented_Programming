package control;

import java.util.Vector;

import model.DataAcessObject;
import model.MSelection;
import model.MUser;
import valueObject.VSelection;
import valueObject.VUser;

public class CSelection {

	public VSelection CSelection(String Id) {
		VSelection vSelection = null;

		DataAcessObject dataAcessObject = new DataAcessObject();
		MSelection mSelection = dataAcessObject.getSelection(Id);
		if (mSelection != null) {
			vSelection = new VSelection(mSelection.getData());
		}
		return vSelection;
	}
}
