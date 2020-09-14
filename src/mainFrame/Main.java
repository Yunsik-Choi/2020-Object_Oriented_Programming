package mainFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) {
		
		PMainFrame pMainFrame = new PMainFrame();
		PLoginDialog pLoginDialog = new PLoginDialog(pMainFrame);
		pLoginDialog.setVisible(true);
//		pMainFrame.setVisible(true);
	}

}
