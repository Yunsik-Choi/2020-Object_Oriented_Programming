package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataAcessObject {

	public MLogin getLogin(String userId) {
		try {
			Scanner scanner = new Scanner(new File("userInfo/userId"));
			MLogin mLogin = new MLogin(scanner, userId);
			while(scanner.hasNext()) {
				boolean found = mLogin.read();
				if(found) {
					scanner.close();
					return mLogin;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
