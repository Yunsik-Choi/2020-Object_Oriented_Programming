package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
	
	public Vector<MModel> getModels(String fileName, Class<?> clazz){
		Vector<MModel> mModels = new Vector<MModel>();
		try {
			Scanner scanner = new Scanner(new File("lectureInfo/" + fileName));
			
			while(scanner.hasNext()) {
				try {
					Constructor constructor = clazz.getConstructor(Scanner.class);
					MModel mModel = (MModel) constructor.newInstance(scanner);
					Method method =  clazz.getDeclaredMethod("read");
					method.invoke(mModel);
					mModels.add(mModel);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mModels;
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
