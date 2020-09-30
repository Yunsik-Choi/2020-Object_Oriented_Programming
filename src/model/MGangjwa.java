package model;

import java.util.Scanner;
import java.util.Vector;

public class MGangjwa {
	private Scanner scanner;
	
	private Vector<String> number;
	private Vector<String> name;
	private Vector<String> pro;
	private Vector<String> credit;
	private Vector<String> time;

	public MGangjwa(Scanner scanner) {
		this.scanner = scanner;
		this.number = new Vector<String>();
		this.name = new Vector<String>();
		this.pro = new Vector<String>();
		this.time = new Vector<String>();
		this.credit = new Vector<String>();
	}

	public void read() {
		while(scanner.hasNext()) {
			this.number.add(scanner.next());
			this.name.add(scanner.next());
			this.credit.add(scanner.next());
			this.pro.add(scanner.next());
			this.time.add(scanner.next());
		}
		
	}
	
	public Vector<String> getNum() {
		return this.number;
	}

	public Vector<String> getName() {
		return this.name;
	}

	public Vector<String> getPro() {
		return this.pro;
	}

	public Vector<String> getTime() {
		return this.time;
	}



}
