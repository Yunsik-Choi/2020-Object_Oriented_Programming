package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import java.util.function.ObjIntConsumer;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sugangShincheong.PContentPanel;
import sugangShincheong.PContentPanel.ListSelectionHandler;
import sugangShincheong.PResult;
import valueObject.VDirectory;
import valueObject.VGangjwa;
import valueObject.VUser;

public class CInfo implements Serializable{
	
	VUser vUser;
	
	public CInfo(VUser vUser) {
		this.vUser = vUser;
		File f = new File("contentInfo/"+vUser.getUserId());
		
		if(!f.isFile()) {
			String path = "contentInfo/"+vUser.getUserId();
			
			ObjectOutputStream objOut = null;
			FileOutputStream fileOut = null;
	
			try {
				fileOut = new FileOutputStream(path);
				objOut = new ObjectOutputStream (fileOut);
				objOut.writeObject(null);
				objOut.close();
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("no");
		}
	}

	public void save(PContentPanel pContentPanel) {
		Vector<Vector> objVec = new Vector<Vector>();
		objVec.add(pContentPanel.pMiridamgi.vGangjwas);
		objVec.add(pContentPanel.pShincheong.vGangjwas);
		
		String path = "contentInfo/"+vUser.getUserId();
		ObjectOutputStream objOut = null;
		FileOutputStream fileOut = null;

		try {
			fileOut = new FileOutputStream(path);
			objOut = new ObjectOutputStream (fileOut);
			objOut.writeObject(objVec);
			objOut.close();
			fileOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void load(PContentPanel pContentPanel,VUser vUser) {

		try {
			FileInputStream inputStream = new FileInputStream("contentInfo/"+vUser.getUserId());
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			
			Vector<Vector> v = (Vector<Vector>) objectInputStream.readObject();
			if(v!=null) {
				pContentPanel.pMiridamgi.setGangjwas(v.get(0));
				pContentPanel.pShincheong.setGangjwas(v.get(1));
				Vector<VGangjwa> vGangjwas = pContentPanel.pSelection.getGangjwaSelection().getData("englishYG");
				vGangjwas = pContentPanel.pMiridamgi.removeDuplicated(vGangjwas);
				vGangjwas = pContentPanel.pShincheong.removeDuplicated(vGangjwas);
				pContentPanel.pSelection.getGangjwaSelection().updateTableContents(vGangjwas);

				
			}else {
				System.out.println("ÆÄÀÏ null");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
