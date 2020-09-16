package sugangShincheong;
import java.awt.BorderLayout;

import javax.swing.JPanel;

import valueObject.VUser;

public class PSugangShincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private PHeaderPanel pHeaderPanel;
	private PContentPanel pContentPanel;
	private PFooterPanel pFooterPanel;
	
	public PSugangShincheongPanel(VUser vUser) {
		this.setLayout(new BorderLayout());
		
		this.pHeaderPanel = new PHeaderPanel(vUser);
		this.add(this.pHeaderPanel, BorderLayout.NORTH);
		
		this.pContentPanel = new PContentPanel();
		this.add(this.pContentPanel, BorderLayout.CENTER);
		
		this.pFooterPanel = new PFooterPanel();
		this.add(this.pFooterPanel, BorderLayout.SOUTH);
	}

}
