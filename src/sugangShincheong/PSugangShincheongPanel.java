package sugangShincheong;
import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PSugangShincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PHeaderPanel pHeaderPanel;
	private PContentPanel pContentPanel;
	private PFooterPanel pFooterPanel;
	
	public PSugangShincheongPanel() {
		this.setLayout(new BorderLayout());
		
		this.pHeaderPanel = new PHeaderPanel();
		this.add(this.pHeaderPanel, BorderLayout.NORTH);
		
		this.pContentPanel = new PContentPanel();
		this.add(this.pContentPanel, BorderLayout.CENTER);
		
		this.pFooterPanel = new PFooterPanel();
		this.add(this.pFooterPanel, BorderLayout.SOUTH);
	}
}
