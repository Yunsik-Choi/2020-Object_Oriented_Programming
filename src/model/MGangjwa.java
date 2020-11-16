package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.VGangjwa;

public class MGangjwa extends MModel{
	private Scanner scanner;
	private FileWriter fileWriter;
	private String id;
	private String name;
	private String lecturer;
	private String credit;
	private String time;
	
	public MGangjwa(Scanner scanner) {
		this.scanner = scanner;
	}

	public MGangjwa(FileWriter fileWriter, VGangjwa vGangjwa) {
		this.fileWriter = fileWriter;
		
		this.id = vGangjwa.getId();
		this.name = vGangjwa.getName();
		this.lecturer = vGangjwa.getLecturer();
		this.credit = vGangjwa.getCredit();
		this.time = vGangjwa.getTime();
	}

	public void read() {
		this.id = scanner.next();
		this.name = scanner.next();
		this.lecturer = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();
	}
	
	public void save() {
		try {
			this.fileWriter.write(this.id+" ");
			this.fileWriter.write(this.name+" ");
			this.fileWriter.write(this.lecturer+" ");
			this.fileWriter.write(this.credit+" ");
			this.fileWriter.write(this.time+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLecturer() {
		return lecturer;
	}

	public String getCredit() {
		return credit;
	}

	public String getTime() {
		return time;
	}



}
