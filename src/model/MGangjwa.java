package model;

import java.util.Scanner;

public class MGangjwa {
private Scanner scanner;
	
	private String id;
	private String name;
	private String lecture;
	private String credit;
	private String time;
	
	public MGangjwa(Scanner scanner) {
		this.scanner = scanner;
	}

	public void read() {
		this.id = scanner.next();
		this.name = scanner.next();
		this.lecture = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLecturer() {
		return lecture;
	}

	public String getCredit() {
		return credit;
	}

	public String getTime() {
		return time;
	}

}
