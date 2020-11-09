package sugangShincheong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import constants.Constants.EConfiguration;
import valueObject.VGangjwa;
import valueObject.VUser;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private VUser vUser;
	
	private ListSelectionListener listSelectionHandler;
	private PSelection pSelection;
	
	private PResult pMiridamgi;
	private PResult pShincheong;
	
	private ActionListener ActionHandler;
	private PMove pMove1;
	private PMove pMove2;
	
	public PContentPanel() {
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.ActionHandler = new ActionHandler();
		
		this.listSelectionHandler = new ListSelectionHandler();
		this.pSelection = new PSelection(this.listSelectionHandler);
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

	public void initialize(VUser vUser) {
		this.vUser = vUser;

		this.pMove1.initialize();
		this.pMove2.initialize();
		
		this.pMiridamgi.initialize(vUser.getUserId()+EConfiguration.miridamgiFilePostfix.getText());
		this.pShincheong.initialize(vUser.getUserId()+EConfiguration.sincheongFilePostfix.getText());
		
		this.pSelection.initialize(this.pMiridamgi.getGangjwas(),this.pShincheong.getGangjwas());
	}
	
	public void save() {
		this.pMiridamgi.save(vUser.getUserId()+EConfiguration.miridamgiFilePostfix.getText());
		this.pShincheong.save(vUser.getUserId()+EConfiguration.sincheongFilePostfix.getText());
	}
	////////////////////////////////////
	//table event handling
	////////////////////////////////////
	private void updateGangjwas(Object source) {
		this.pSelection.updateGangjwas(source, this.pMiridamgi.getGangjwas(), this.pShincheong.getGangjwas());
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
	private void moveGangjwas(PGangjwaContainer source,PGangjwaContainer target) {
		Vector<VGangjwa> vSelectedGangjwas = source.removeSelectedGangjwas();
		target.addGangjwas(vSelectedGangjwas);
	}
	
	private void moveGangjwas(Object source) {
		if(source.equals(this.pMove1.getMoveRightButton())) {
			this.moveGangjwas(this.pSelection,this.pMiridamgi);
		}
		else if(source.equals(this.pMove1.getMoveLeftButton())) {
			this.moveGangjwas(this.pMiridamgi,this.pSelection);
		}
		else if(source.equals(this.pMove2.getMoveRightButton())) {
			this.moveGangjwas(this.pMiridamgi,this.pShincheong);
		}else if(source.equals(this.pMove2.getMoveLeftButton())) {
			this.moveGangjwas(this.pShincheong,this.pMiridamgi);
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
