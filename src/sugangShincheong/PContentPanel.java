package sugangShincheong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import valueObject.VGangjwa;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PSelection pSelection;
	private PMove pMove1;
	private PResult pMiridamgi;
	private PMove pMove2;
	private PResult pShincheong;
	
	private ActionListener ActionHandler;
	public PContentPanel() {
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.ActionHandler = new ActionHandler();
		
		ListSelectionListener listSelectionHandler = new ListSelectionHandler();
		this.pSelection = new PSelection(listSelectionHandler);
		this.add(this.pSelection);
		
		this.pMove1 = new PMove(this.ActionHandler);
		this.add(this.pMove1);
		
		this.pMiridamgi = new PResult();
		JScrollPane scrollPane = new JScrollPane(this.pMiridamgi);
		this.add(scrollPane);
		
		this.pMove2 = new PMove(this.ActionHandler);
		this.add(this.pMove2);
		
		this.pShincheong = new PResult();
		scrollPane = new JScrollPane(this.pShincheong);
		this.add(scrollPane);
	}

	public void initialize() {
		this.pSelection.initialize();
		this.pMove1.initialize();
		this.pMiridamgi.initialize();
		this.pMove2.initialize();
		this.pShincheong.initialize();
	}
	////////////////////////////////////
	//table event handling
	/////////////////////
	private void updateGangjwas(Object source) {
		String fileName = this.pSelection.getHakgwaSelection().update(source);
		Vector<VGangjwa> vGangjwas = this.pSelection.getGangjwaSelection().getData(fileName);
		vGangjwas = this.pMiridamgi.removeDuplicated(vGangjwas);
		vGangjwas = this.pShincheong.removeDuplicated(vGangjwas);
		this.pSelection.getGangjwaSelection().updateTableContents(vGangjwas);
	}
	
	public class ListSelectionHandler implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent event) {
			updateGangjwas(event.getSource());
		}
		
	}
	
	////////////////////////////////////
	//button event handling
	/////////////////////
	private void moveGangjwas(Object source) {
		Vector<VGangjwa> vSelectedGangjwas;
		if(source.equals(this.pMove1.getMoveRightButton())) {
			vSelectedGangjwas =  this.pSelection.getSelectedGangjwas();
			vSelectedGangjwas = this.pMiridamgi.removeDuplicated(vSelectedGangjwas);
			vSelectedGangjwas = this.pShincheong.removeDuplicated(vSelectedGangjwas);
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);
		}
		else if(source.equals(this.pMove1.getMoveLeftButton())) {
			vSelectedGangjwas = this.pMiridamgi.removeGangjwa();
		}
		else if(source.equals(this.pMove2.getMoveRightButton())) {
			vSelectedGangjwas =  this.pMiridamgi.removeGangjwa();
			this.pShincheong.addGangjwas(vSelectedGangjwas);
		}else if(source.equals(this.pMove2.getMoveLeftButton())) {
			vSelectedGangjwas = this.pShincheong.removeGangjwa();
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);
		}
	}

	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			moveGangjwas(event.getSource());
		}
		
	}
}
