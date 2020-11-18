package control;

import model.DataAcessObject;
import model.MLogin;
import model.MModel;
import model.MUser;
import valueObject.VUser;

public class CUser {

	public VUser getUser(String userId) {
		VUser vUser = null;
		
		DataAcessObject dataAcessObject = new DataAcessObject();
		MModel mModel = dataAcessObject.getAModel(userId, MUser.class, userId);
		if (mModel != null) {
			MUser mUser = (MUser) mModel;
			vUser = new VUser(mUser.getUserId(),mUser.getName(),mUser.getAddress());
		}
		return vUser;
	}

}
