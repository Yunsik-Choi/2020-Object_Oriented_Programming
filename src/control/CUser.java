package control;

import model.DataAcessObject;
import model.MLogin;
import model.MUser;
import valueObject.VUser;

public class CUser {

	public VUser getUser(String userId) {
		VUser vUser = null;
		
		DataAcessObject dataAcessObject = new DataAcessObject();
		MUser mUser = dataAcessObject.getUser(userId);
		if (mUser != null) {
			vUser = new VUser(mUser.getUserId(),mUser.getName(),mUser.getAddress());
		}
		return vUser;
	}

}
