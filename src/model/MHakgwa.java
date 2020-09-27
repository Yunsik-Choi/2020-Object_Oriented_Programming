package model;

import java.util.Scanner;
import java.util.Vector;

import valueObject.VHakgwa;

public class MHakgwa {

	private Scanner scanner;
	private int index;

	private Vector<VHakgwa> vecHakgwa = new Vector<VHakgwa>();
	
	public MHakgwa(Scanner scanner) {
		// TODO Auto-generated constructor stub
		this.scanner = scanner;
		while(scanner.hasNext()) {
			String str = scanner.nextLine();
			if(str!=null) {
				String[] splitstr = str.split(" ");
				VHakgwa vHakgwa = new VHakgwa(Integer.parseInt(splitstr[0]), splitstr[1], splitstr[2]);
				this.vecHakgwa.add(vHakgwa);
			}
		}
	}
	public Vector<String> getTitle() {
		Vector<String> vec = new Vector<String>();
		for(VHakgwa i : vecHakgwa) {
			vec.add(i.getTitle());
		}
		return vec;
	}
	public String getIndex(int index) {
		String name = this.vecHakgwa.get(index).getFile();
		return name;
	}

}
