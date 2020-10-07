package model;

import java.util.Scanner;

public class MGangjwa {

	private Scanner scanner;
	
	private String num;
	private String title;
	private String pro;
	private String credit;
	private String time;
	
	public MGangjwa(Scanner scanner) {
		this.scanner = scanner;
	}

	public void read() {
		this.num = this.scanner.next();
		this.title = this.scanner.next();
		this.pro = this.scanner.next();
		this.credit = this.scanner.next();
		this.time = this.scanner.next();
	}
	
	public String getNum() {
		return num;
	}

	public String getTitle() {
		return title;
	}
	
	public String getCredit() {
		return credit;
	}
	public String getPro() {
		return pro;
	}

	public String getTime() {
		return time;
	}





}
