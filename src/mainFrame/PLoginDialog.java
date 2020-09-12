package mainFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.CLogin;
import constants.Constants.ELoginDialog;
import dto.VUserInfo;

public class PLoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private PMainFrame pMainframe;
	
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancelButton;
	
	private ActionHandler actionHandler;
	
	public PLoginDialog(PMainFrame pMainFrame) {
		super(pMainFrame,true);
		this.pMainframe = pMainFrame;
		this.setSize(ELoginDialog.width.getInt(),ELoginDialog.height.getInt());
		this.setResizable(false);
		
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
		VUserInfo vUserInfo =  cLogin.validateUser(this.nameText.getText(),this.passwordText.getText());
		if(vUserInfo!=null&&vUserInfo.getId()!=null) {
			this.pMainframe.pMainPanel.pHeaderPanel.setUserName(vUserInfo.getName());
			dispose();
		}
	}
	
	private class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand().equals(ELoginDialog.okButtonLabel.getText())) {
				validateUser();
			}
			
		}
		
	}
}
