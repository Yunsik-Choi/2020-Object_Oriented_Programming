package mainFrame;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.ELoginDialog;
import control.CLogin;
import control.CUser;
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
	private VUser vUser;
	
	public PLoginDialog(ActionHandler actionHandler) {
		this.setSize(ELoginDialog.width.getInt(),ELoginDialog.height.getInt());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
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
	
	public JButton getOKButton() {
		return this.okButton;
	}
	public JButton getCancleButton() {
		return this.cancelButton;
	}
	public void validateUser() {
		CLogin cLogin = new CLogin();
		VLogin vLogin = new VLogin(this.UserIdTextField.getText(),this.passwordTextField.getText());
		boolean bLoginSuccess =  cLogin.validate(vLogin);
		if(bLoginSuccess) {
			CUser cUser = new CUser();
			this.vUser = cUser.getUser(vLogin.getUserId());
			
			if(vUser != null) {

			} else {
				// �ý��� ����
				JOptionPane.showMessageDialog(null, "�ý��� ����");
			}
		} else {
			// �α��� ����
			JOptionPane.showMessageDialog(null, "�α��� ����");
		}
	}
	
	public VUser getVUser() {
		return this.vUser;
	}
}
