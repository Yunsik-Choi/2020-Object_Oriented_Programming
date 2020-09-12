package constants;

import dao.DAOUserLogin;
import dto.DTOUserLogin;
import dto.VUserInfo;

public class CLogin {
	public DTOUserLogin dtoUserLogin = new DTOUserLogin();
	public DAOUserLogin daoUserLogin;
	public VUserInfo validateUser(String text, String text2) {
		this.dtoUserLogin.setId(text);
		this.dtoUserLogin.setPw(text2);
		this.daoUserLogin = new DAOUserLogin(text, text2);
		return this.daoUserLogin.getVUser();
    }
	
	public DTOUserLogin getDTOUserLogin() {
		return this.dtoUserLogin;
	}
	
	public DAOUserLogin getDAOUserLogin() {
		return this.daoUserLogin;
	}

}
