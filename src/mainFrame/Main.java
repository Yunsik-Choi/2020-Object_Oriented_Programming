package mainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PMainFrame pMainFrame = new PMainFrame();

		PLoginDialog pLoginDialog = new PLoginDialog(pMainFrame);
		pLoginDialog.setVisible(true);

		pMainFrame.setVisible(true);
	}

}
