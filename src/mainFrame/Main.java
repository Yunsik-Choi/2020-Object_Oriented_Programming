package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import constants.Constants.ELoginDialog;

public class Main {

	public static void main(String[] args) {
		MainController mainController = new MainController();
		mainController.actionHandle();
	}

}
class ActionHandler implements ActionListener{
	public PLoginDialog pLoginDialog;
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals(pLoginDialog.getOKButton().getActionCommand())) {
			pLoginDialog.validateUser();
			if(pLoginDialog.getVUser()!=null) {
				PMainFrame pMainFrame = new PMainFrame(pLoginDialog.getVUser());
				pLoginDialog.dispose();
				pMainFrame.setVisible(true);
			}
		}
		else if(event.getActionCommand().equals(pLoginDialog.getCancleButton().getActionCommand())) {
			int result = JOptionPane.showConfirmDialog(null, "프로그램을 종료하시겠습니까?", "Confirm cancle Button",0 );
			if(result==0) {
				System.exit(0);
			}
		}
		
	}
	
}
class MainController{
	private ActionHandler actionHandler;
	public void actionHandle() {
		this.actionHandler = new ActionHandler();
		actionHandler.pLoginDialog = new PLoginDialog(actionHandler);
		actionHandler.pLoginDialog.setVisible(true);
	}
}
