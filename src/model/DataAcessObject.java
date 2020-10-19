package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;
import valueObject.VUser;

public class DataAcessObject {

	public MLogin getLogin(String userId) {
		MLogin mLogin = null;
		try {
			Scanner scanner = new Scanner(new File("userInfo/userId"));
			mLogin = new MLogin(scanner, userId);
			while(scanner.hasNext()) {
				boolean found = mLogin.read();
				if(found) {
					scanner.close();
					return mLogin;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public MUser getUser(String userId) {
		MUser mUser = null;
		try {
			Scanner scanner = new Scanner(new File("userInfo/" + userId));
			mUser = new MUser(scanner, userId);
			while(scanner.hasNext()) {
				boolean found = mUser.read();
				if(found) {
					scanner.close();
					return mUser;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Vector<MDirectory> getDirectories(String fileName) {
		Vector<MDirectory> mDirectories = new Vector<MDirectory>();
		try {
			Scanner scanner = new Scanner(new File("lectureInfo/" + fileName));
			
			while(scanner.hasNext()) {
				MDirectory mDirectory = new MDirectory(scanner);
				mDirectory.read();
				mDirectories.add(mDirectory);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mDirectories;
	}

	public Vector<MGangjwa> getGangjwas(String fileName) {
		Vector<MGangjwa> mGangjwas = new Vector<MGangjwa>();
		try {
			Scanner scanner = new Scanner(new File("lectureInfo/" + fileName));
			
			while(scanner.hasNext()) {
				MGangjwa mGangjwa = new MGangjwa(scanner);
				mGangjwa.read();
				mGangjwas.add(mGangjwa);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mGangjwas;
	}

	public void addGangjwas(VUser vUser, Vector<VGangjwa> vSelectedGangjwas) {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("courseInfo/" + vUser.getUserId(),true));
			for(VGangjwa vGangjwa : vSelectedGangjwas) {
				String str = vGangjwa.getId()+" "+vGangjwa.getName()+" "+vGangjwa.getLecturer()
				+" "+vGangjwa.getCredit()+" "+vGangjwa.getTime();
				fw.write(str);
				fw.newLine();
			}
			fw.close();
			
		}catch(FileNotFoundException e) {

		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void removeGangjwas(VUser vUser, Vector<VGangjwa> vSelectedGangjwas) {
		try {
			
			Scanner scanner = new Scanner(new File("courseInfo/" + vUser.getUserId()));
			Vector<VGangjwa> preserveGangjwa = new Vector<VGangjwa>();
			while(scanner.hasNext()) {
				VGangjwa vGangjwa = new VGangjwa(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next());
				preserveGangjwa.add(vGangjwa);
			}
			Vector<VGangjwa> removeGangjwa = new Vector<VGangjwa>();
			for(VGangjwa i : preserveGangjwa) {
				for(VGangjwa l : vSelectedGangjwas) {
					if(i.getId().equals(l.getId())) {
						removeGangjwa.add(i);
					}
				}
			}
			for(VGangjwa vGangjwa: removeGangjwa) {
				preserveGangjwa.remove(vGangjwa);
			}

			BufferedWriter fw = new BufferedWriter(new FileWriter("courseInfo/" + vUser.getUserId()));
			for(VGangjwa vGangjwa : preserveGangjwa) {
				String str = vGangjwa.getId()+" "+vGangjwa.getName()+" "+vGangjwa.getLecturer()
				+" "+vGangjwa.getCredit()+" "+vGangjwa.getTime();
				fw.write(str);
				fw.newLine();
			}
			fw.close();
			scanner.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Vector<VGangjwa> getPreserveGangjwas(String userId) {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("courseInfo/" + userId,true));
			fw.close();
			Scanner scanner = new Scanner(new File("courseInfo/" + userId));
			Vector<VGangjwa> preserveGangjwa = new Vector<VGangjwa>();
			while(scanner.hasNext()) {
				VGangjwa vGangjwa = new VGangjwa(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next());
				preserveGangjwa.add(vGangjwa);
			}
			return preserveGangjwa;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addShincheong(VUser vUser, Vector<VGangjwa> vSelectedGangjwas) {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("shincheongInfo/" + vUser.getUserId(),true));
			for(VGangjwa vGangjwa : vSelectedGangjwas) {
				String str = vGangjwa.getId()+" "+vGangjwa.getName()+" "+vGangjwa.getLecturer()
				+" "+vGangjwa.getCredit()+" "+vGangjwa.getTime();
				fw.write(str);
				fw.newLine();
			}
			fw.close();
			
		}catch(FileNotFoundException e) {

		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeShincheong(VUser vUser, Vector<VGangjwa> vSelectedGangjwas) {
		try {
			
			Scanner scanner = new Scanner(new File("shincheongInfo/" + vUser.getUserId()));
			Vector<VGangjwa> preserveGangjwa = new Vector<VGangjwa>();
			while(scanner.hasNext()) {
				VGangjwa vGangjwa = new VGangjwa(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next());
				preserveGangjwa.add(vGangjwa);
			}
			Vector<VGangjwa> removeGangjwa = new Vector<VGangjwa>();
			for(VGangjwa i : preserveGangjwa) {
				for(VGangjwa l : vSelectedGangjwas) {
					if(i.getId().equals(l.getId())) {
						removeGangjwa.add(i);
					}
				}
			}
			for(VGangjwa vGangjwa: removeGangjwa) {
				preserveGangjwa.remove(vGangjwa);
			}

			BufferedWriter fw = new BufferedWriter(new FileWriter("shincheongInfo/" + vUser.getUserId()));
			for(VGangjwa vGangjwa : preserveGangjwa) {
				String str = vGangjwa.getId()+" "+vGangjwa.getName()+" "+vGangjwa.getLecturer()
				+" "+vGangjwa.getCredit()+" "+vGangjwa.getTime();
				fw.write(str);
				fw.newLine();
			}
			fw.close();
			scanner.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Vector<VGangjwa> getPreserveShincheong(String userId) {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("shincheongInfo/" + userId,true));
			fw.close();
			Scanner scanner = new Scanner(new File("shincheongInfo/" + userId));
			Vector<VGangjwa> preserveGangjwa = new Vector<VGangjwa>();
			while(scanner.hasNext()) {
				VGangjwa vGangjwa = new VGangjwa(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next());
				preserveGangjwa.add(vGangjwa);
			}
			return preserveGangjwa;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
