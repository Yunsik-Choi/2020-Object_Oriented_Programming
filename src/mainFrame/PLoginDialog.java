package mainFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.ELoginDialog;
import control.CLogin;
import control.CUser;
import mainFrame.Main.ActionHandler;
import valueObject.VLogin;
import valueObject.VUser;

public class PLoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JLabel userIdLabel;
	private JTextField UserIdTextField;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JButton okButton;
	private JButton cancelButton;
	
	public PLoginDialog(ActionHandler actionHandler) {
		this.setSize(ELoginDialog.width.getInt(),ELoginDialog.height.getInt());
		this.setResizable(false);
		
		this.setLayout(new FlowLayout());
		
		JPanel line1 = new JPanel();
		JPanel line2 = new JPanel();
		JPanel line3 = new JPanel();
		
		this.userIdLabel = new JLabel(ELoginDialog.nameLabel.getText());
		line1.add(this.userIdLabel);
		
		this.UserIdTextField = new JTextField(ELoginDialog.sizeNameText.getInt());
		line1.add(this.UserIdTextField);
		
		this.passwordLabel = new JLabel(ELoginDialog.passwordLabel.getText());
		line2.add(this.passwordLabel);
		
		this.passwordTextField = new JTextField(ELoginDialog.sizePasswordText.getInt());
		line2.add(this.passwordTextField);
		
		this.okButton = new JButton(ELoginDialog.okButtonLabel.getText());
		this.okButton.addActionListener(actionHandler);
		this.okButton.setActionCommand(this.okButton.getText());
		line3.add(this.okButton);
		
		this.cancelButton = new JButton(ELoginDialog.cancelButtonLabel.getText());
		this.cancelButton.addActionListener(actionHandler);
		this.cancelButton.setActionCommand(this.cancelButton.getText());
		line3.add(this.cancelButton);
		
		this.add(line1);
		this.add(line2);
		this.add(line3);
	}
	
	public VUser validateUser(String actionCommand) {
		VUser vUser = null;
		if(actionCommand.contentEquals(this.okButton.getText())) {
			CLogin cLogin = new CLogin();
			VLogin vLogin = new VLogin(this.UserIdTextField.getText(),this.passwordTextField.getText());
			boolean bLoginSuccess =  cLogin.validate(vLogin);
			if(bLoginSuccess) {
				CUser cUser = new CUser();
				vUser = cUser.getUser(vLogin.getUserId());
				if(vUser == null) {
					JOptionPane.showConfirmDialog(this, "회원정보가 존재하지 않습니다.");
				}
			} else {
				// 로그인 실패
				JOptionPane.showConfirmDialog(this, "아이디나 비밀번호가 존재하지 않습니다.");
			}
		}
		return vUser;
	}
	
}
