package model;

import java.util.Scanner;

import valueObject.VUser;

public class MUser {
	private String userId;
	private String userName;
	private Scanner scanner;
	private VUser vUser;
	public MUser(Scanner scanner, String userId) {
		this.userId = userId;
		this.scanner = scanner;
	}

	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}

	public VUser getUserVO() {
		return this.vUser;
	}
	
	public void setUserVO() {
		this.userId = scanner.next();
		this.userName = scanner.next();
		this.vUser = new VUser(this.userId,this.userName);
	}
}
