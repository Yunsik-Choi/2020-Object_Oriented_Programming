package model;

import java.util.Scanner;
import java.util.Vector;

public class MSelection {
	Vector<String> data;
	public MSelection(Scanner scanner) {
		this.data = new Vector<String>();
		while(scanner.hasNext()==true) {
			data.add(scanner.nextLine());
		}
	}

	public Vector<String> getData() {
		// TODO Auto-generated method stub
		return data;
	}

}
