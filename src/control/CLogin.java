package control;

import javax.swing.JOptionPane;

import model.DataAcessObject;
import model.MLogin;
import valueObject.VLogin;

public class CLogin {

	public boolean validate(VLogin vLogin) {
		boolean bLoginSuccess = false;
		DataAcessObject dataAcessObject = new DataAcessObject();
		MLogin mLogin = dataAcessObject.getLogin(vLogin.getUserId());
		if(mLogin != null) {
			if(vLogin.getPassword().contentEquals(mLogin.getPassword())) {
				bLoginSuccess = true;
				return bLoginSuccess;
			}
			else {
				//password mismatch
				JOptionPane.showMessageDialog(null, "Password mismatch");
			}
		}
		else {
			//no Userid
			JOptionPane.showMessageDialog(null, "No UserId");
		}
		return false;
	}
}
