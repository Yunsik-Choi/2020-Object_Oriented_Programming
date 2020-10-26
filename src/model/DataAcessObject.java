package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;

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
			e.printStackTrace();
		}
		return null;
	}

	public Vector<MDirectory> getDirectories(String fileName) {
		Vector<MDirectory> mDirectories = new Vector<MDirectory>();
		try {
			Scanner scanner = new Scanner(new File("lectureInfo/" + fileName));
			
			while(scanner.hasNext()) {
				MDirectory mDirectory = new MDirectory(scanner);
				mDirectory.read();
				mDirectories.add(mDirectory);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mDirectories;
	}

	public Vector<MGangjwa> getGangjwas(String fileName) {
		Vector<MGangjwa> mGangjwas = new Vector<MGangjwa>();
		try {
			Scanner scanner = new Scanner(new File("lectureInfo/" + fileName));
			
			while(scanner.hasNext()) {
				MGangjwa mGangjwa = new MGangjwa(scanner);
				mGangjwa.read();
				mGangjwas.add(mGangjwa);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mGangjwas;
	}

	public void saveResult(String fileName, Vector<VGangjwa> vGangjwas) {
		try {
			FileWriter fileWriter = new FileWriter(new File("userInfo/"+fileName));
			for(VGangjwa vGangjwa: vGangjwas) {
				MGangjwa mGangjwa = new MGangjwa(fileWriter,vGangjwa);
				mGangjwa.save();
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Vector<MGangjwa> getResult(String fileName) {
		Vector<MGangjwa> mGangjwas = new Vector<MGangjwa>();
		try {
			Scanner scanner = new Scanner(new File("userInfo/" + fileName));
			
			while(scanner.hasNext()) {
				MGangjwa mGangjwa = new MGangjwa(scanner);
				mGangjwa.read();
				mGangjwas.add(mGangjwa);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mGangjwas;
	}
}
