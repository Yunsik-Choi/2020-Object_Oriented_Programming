package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.Constants.ELoginDialog;

public class Main {

	private PLoginDialog pLoginDialog;
	public static void main(String[] args) {
		
		ActionHandler actionHandler = new ActionHandler();
		pLoginDialog = new PLoginDialog(actionHandler);
		pLoginDialog.setVisible(true);

		PMainFrame pMainFrame = new PMainFrame(vUser);
		pMainFrame.setVisible(true);
	}
	
	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand().equals(ELoginDialog.okButton.getText())) {
				pLoginDialog.validateUser();
			}
			
		}
		
	}

}
