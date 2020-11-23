package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;

public class DataAcessObject {
	
	public MModel getAModel(String fileName, Class<?> clazz, String key) {
		MLogin mLogin = null;
		try {
			Scanner scanner = new Scanner(new File("userInfo/"+fileName));
			
			Constructor<?> constructor = clazz.getConstructor();
			MModel mModel = (MModel) constructor.newInstance();

			while(scanner.hasNext()) {
				String mModelKey = mModel.read(scanner);
				if(mModelKey.contentEquals(key)) {
					scanner.close();
					return mModel;
				}
			}
			scanner.close();
		} catch (FileNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Vector<MModel> getModels(String fileName, Class<?> clazz) {
		Vector<MModel> mModels = new Vector<MModel>();
		try {
			Scanner scanner = new Scanner(new File("lectureInfo/" + fileName));
			while(scanner.hasNext()) {
				Constructor<?> constructor = clazz.getConstructor();
				MModel mModel = (MModel) constructor.newInstance();
				mModel.read(scanner);
				mModels.add(mModel);
			}
			scanner.close();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | FileNotFoundException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return mModels;
	}


	public void save(String fileName, Vector<MModel> mModels) {
		try {
			FileWriter fileWriter = new FileWriter(new File("lectureInfo/"+fileName));
			for(MModel mModel: mModels) {
				mModel.save(fileWriter);
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
