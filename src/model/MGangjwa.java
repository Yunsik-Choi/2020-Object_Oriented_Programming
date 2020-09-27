package model;

import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;

public class MGangjwa {
	private Scanner scanner;
	private Vector<VGangjwa> gangjwaVO = new Vector<VGangjwa>();
	
	public MGangjwa(Scanner scanner) {
		// TODO Auto-generated constructor stub
		this.scanner = scanner;
		while(scanner.hasNext()) {
			String str = scanner.nextLine();
			if(str!=null) {
				String[] temp = str.split(" ");
				VGangjwa vGangjwa = 
				new VGangjwa(temp[0], temp[1], temp[2], temp[3], temp[4]);
				gangjwaVO.add(vGangjwa);
			}
		}
	}
	
	public Vector<VGangjwa> getGangjwa(){
		return this.gangjwaVO;
	}

}
