package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.Constants.ELoginDialog;
import valueObject.VUser;

public class Main {

	private PLoginDialog pLoginDialog;
	private PMainFrame pMainFrame;
	private void run() {
		ActionHandler actionHandler = new ActionHandler();
		this.pLoginDialog = new PLoginDialog(actionHandler);
		this.pLoginDialog.setVisible(true);
	}
	private void validateUser(String actionCommand) {
		VUser vUser = pLoginDialog.validateUser(actionCommand);
		if(vUser !=null) {
			this.pMainFrame = new PMainFrame(vUser);
			this.pMainFrame.setVisible(true);
		}
		pLoginDialog.dispose();
	}
	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			validateUser(event.getActionCommand());
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

}
