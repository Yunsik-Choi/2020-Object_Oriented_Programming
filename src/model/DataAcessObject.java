package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataAcessObject {

	public MLogin getLogin(String userId) {
		MLogin mLogin = null;
		try {
			Scanner scanner = new Scanner(new File("userInfo/userId"));
			mLogin = new MLogin(scanner, userId);
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

	public MUser getUser(String userId) {
		MUser mUser = null;
		try {
			Scanner scanner = new Scanner(new File("userInfo/" + userId));
			mUser = new MUser(scanner, userId);
			while(scanner.hasNext()) {
				boolean found = mUser.read();
				if(found) {
					scanner.close();
					return mUser;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public MHakgwa getHakgwa(String title) {
		MHakgwa mHakgwa = null;
		try {
			Scanner scanner = new Scanner(new File("data/" + title));
			mHakgwa = new MHakgwa(scanner);
			scanner.close();
			return mHakgwa;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MGangjwa getGangjwa(String fname) {
		MGangjwa mGangjwa = null;
		try {
			Scanner scanner = new Scanner(new File("data/" + fname));
			mGangjwa = new MGangjwa(scanner);
			scanner.close();
			return mGangjwa;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
