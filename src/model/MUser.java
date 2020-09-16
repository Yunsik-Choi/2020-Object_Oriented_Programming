package model;

import java.util.Scanner;

public class MUser {
	private Scanner scanner;
	
	private String userId;
	private String name;
	private String address;
	
	public MUser(Scanner scanner, String userId) {
		this.userId = userId;
		this.scanner = scanner;
	}

	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}


	public boolean read() {
		String userId = scanner.next();
		this.name = scanner.next();
		this.address = scanner.next();
		
		if(this.userId.contentEquals(userId)) {
			return true;
		}
		return false;
	}

}
