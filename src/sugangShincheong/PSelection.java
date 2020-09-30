package sugangShincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PSelection extends JPanel {
	private static final long serialVersionUID = 1L;

	private PHakgwaSelection pHakgwaSelection;
	private PGangjwaSelection pGangjwaSelection;
	private Vector<String> searchDirectory = new Vector<String>();
	private ListSelectionHandler listSelectionHandler;
	public PSelection() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.listSelectionHandler = new ListSelectionHandler();
		this.pHakgwaSelection = new PHakgwaSelection(listSelectionHandler);
		this.add(pHakgwaSelection);
		JScrollPane scrollPane = new JScrollPane();
		this.pGangjwaSelection = new PGangjwaSelection();
		scrollPane.setViewportView(this.pGangjwaSelection);
		this.pHakgwaSelection.setDefault();
		this.add(scrollPane);
	}
	
	private void update(Object source) {
		String s = source.toString();
		String[] temp = s.split(" ");
		this.searchDirectory.add(temp[1]);
		if(pHakgwaSelection!=null) {
			this.pHakgwaSelection.update(source,searchDirectory);
			String fileName = this.pHakgwaSelection.getFileName();
			this.pGangjwaSelection.update(fileName);
		}
	}
	
	public class ListSelectionHandler implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent event) {
			if(!event.getValueIsAdjusting()) {
				update(event.getSource());
			}
		}
	}
}
