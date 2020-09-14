package control;

import model.DataAcessObject;
import model.MUser;
import valueObject.VLogin;
import valueObject.VUser;

public class CUser {

	public VUser getUser(VLogin vLogin) {
		vLogin = vLogin;
		DataAcessObject dataAcessObject = new DataAcessObject();
		MUser mUser = dataAcessObject.getUser(vLogin.getUserId());
		if(mUser!=null) {
			mUser.setUserVO();
			VUser vUser = mUser.getUserVO();
			return vUser;
		}
		return null;
	}

}
