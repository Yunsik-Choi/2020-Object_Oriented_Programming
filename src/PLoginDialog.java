import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PLoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JButton okButton;
	private JButton cancelButton;
	
	public PLoginDialog(Frame parent) {
		super(parent,true);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		nameLabel = new JLabel("아이디 : ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(nameLabel, cs);
		
		nameText = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(nameText, cs);
		
		passwordLabel = new JLabel("비밀번호 : ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(passwordLabel, cs);
		
		passwordText = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(passwordText, cs);
	    panel.setBorder(new LineBorder(Color.GRAY));
		okButton = new JButton("로그인");
		
		okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });
		
		cancelButton = new JButton("취소");
 
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });
		
		JPanel bp = new JPanel();
        bp.add(okButton);
        bp.add(cancelButton);
        
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
	}
	
	public String getUsername() {
		return nameText.getText().trim();
	}
}
