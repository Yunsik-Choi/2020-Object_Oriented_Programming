package control;

import model.DataAcessObject;
import model.MLogin;
import model.MModel;
import valueObject.VLogin;

public class CLogin {

	public boolean validate(VLogin vLogin) {
		boolean bLoginSuccess = false;
		DataAcessObject dataAcessObject = new DataAcessObject();
		MModel mModel = dataAcessObject.getAModel("userid",MLogin.class,vLogin.getUserId());
		if(mModel != null) {
			MLogin mLogin = (MLogin) mModel;
			if(vLogin.getPassword().contentEquals(mLogin.getPassword())) {
				bLoginSuccess = true;
			}
			else {
				//password mismatch
			}
		}
		else {
			//no Userid
		}
		return bLoginSuccess;
	}
}
