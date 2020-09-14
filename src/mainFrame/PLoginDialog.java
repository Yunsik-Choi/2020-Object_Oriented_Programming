package mainFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.ELoginDialog;
import control.CLogin;
import control.CUser;
import valueObject.VLogin;
import valueObject.VUser;

public class PLoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancelButton;
	
	private ActionHandler actionHandler;
	
	public PMainFrame pMainFrame;
	
	public boolean closeDialog = false;
	
	public PLoginDialog(PMainFrame pMainFrame) {
		super(pMainFrame,true);
		this.pMainFrame = pMainFrame;
		this.setSize(ELoginDialog.width.getInt(),ELoginDialog.height.getInt());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				if(closeDialog==false) {
					System.exit(0);
				}
			}
		});
		this.actionHandler = new ActionHandler();
		this.setLayout(new FlowLayout());
		
		JPanel line1 = new JPanel();
		JPanel line2 = new JPanel();
		JPanel line3 = new JPanel();
		
		this.nameLabel = new JLabel(ELoginDialog.nameLabel.getText());
		line1.add(this.nameLabel);
		
		this.nameText = new JTextField(ELoginDialog.sizeNameText.getInt());
		line1.add(this.nameText);
		
		this.passwordLabel = new JLabel(ELoginDialog.passwordLabel.getText());
		line2.add(this.passwordLabel);
		
		this.passwordText = new JTextField(ELoginDialog.sizePasswordText.getInt());
		line2.add(this.passwordText);
		
		this.okButton = new JButton(ELoginDialog.okButtonLabel.getText());
		this.okButton.addActionListener(this.actionHandler);
		this.okButton.setActionCommand(this.okButton.getText());
		line3.add(this.okButton);
		
		this.cancelButton = new JButton(ELoginDialog.cancelButtonLabel.getText());
		this.cancelButton.addActionListener(this.actionHandler);
		this.cancelButton.setActionCommand(this.cancelButton.getText());
		line3.add(this.cancelButton);
		
		this.add(line1);
		this.add(line2);
		this.add(line3);
	}
	
	private void validateUser() {
		CLogin cLogin = new CLogin();
		VLogin vLogin = new VLogin(this.nameText.getText(),this.passwordText.getText());
		boolean bLoginSuccess =  cLogin.validate(vLogin);
		if(bLoginSuccess) {
			CUser cUser = new CUser();
			VUser vUser = cUser.getUser(vLogin);
			this.pMainFrame.getPMainPanel().getPHeaderPanel().setHeaderLabel(vUser.getName());
			this.closeDialog = true;
			dispose();
			this.pMainFrame.setVisible(true);
		}
	}
	
	private class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand().equals(ELoginDialog.okButtonLabel.getText())) {
				validateUser();
			}
			else if(event.getActionCommand().equals(ELoginDialog.cancelButtonLabel.getText())) {
				System.exit(0);
				dispose();
				
			}
		}
		
	}
}
