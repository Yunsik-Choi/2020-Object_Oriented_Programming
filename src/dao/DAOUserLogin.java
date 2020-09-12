package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import constants.CLogin;
import dto.DTOUserLogin;
import dto.VUserInfo;

public class DAOUserLogin {
	boolean vLogin = false;
	private String userID;
	private VUserInfo vUserInfo = new VUserInfo();
	public DAOUserLogin(String text, String text2) {
		try{
	        File file = new File("C:\\Users\\choiy\\eclipse-workspace\\2Lms_swing\\userInfo\\userId");
	        FileReader file_reader = new FileReader(file);
	        BufferedReader bufReader = new BufferedReader(file_reader);
	        String line = "";
	        while((line = bufReader.readLine()) != null){
	           String[] log = line.split(" ");
	           if(text.equals(log[0])&&text2.equals(log[1])) {
	        	   this.vLogin = true;
	        	   this.userID = log[0];
	        	   DoLogin();
	        	   break;
	           }
	        }
	        bufReader.close();
	        file_reader.close();
	        }
	    catch (IOException e) {
	        System.out.println(e);
	    }
	}
	
	public void DoLogin() {
		if(this.vLogin==true) {
			try{
				File file = new File("C:\\Users\\choiy\\eclipse-workspace\\2Lms_swing\\userInfo\\"+this.userID);
		        FileReader file_reader = new FileReader(file);
		        BufferedReader bufReader = new BufferedReader(file_reader);
		        String line = "";
		        while((line = bufReader.readLine()) != null){
		           String[] log = line.split(" ");
		           vUserInfo.setId(log[0]);
		           vUserInfo.setName(log[1]);
		        }
		        bufReader.close();
		        file_reader.close();
			}
			
		    catch (IOException e){
		        System.out.println(e);
		    }
		}
	}
	
	public VUserInfo getVUser() {
		return this.vUserInfo;
	}
	
}
