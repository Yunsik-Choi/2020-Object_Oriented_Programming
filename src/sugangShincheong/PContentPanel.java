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
	private void moveGangjwas(Object source) {
		Vector<VGangjwa> vSelectedGangjwas;
		if(source.equals(this.pMove1.getMoveRightButton())) {
			vSelectedGangjwas =  this.pSelection.getSelectedGangjwas();
			vSelectedGangjwas = this.pMiridamgi.removeDuplicated(vSelectedGangjwas);
			vSelectedGangjwas = this.pShincheong.removeDuplicated(vSelectedGangjwas);
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);
			
			this.updateGangjwas(source);
		}
		else if(source.equals(this.pMove1.getMoveLeftButton())) {
			vSelectedGangjwas = this.pMiridamgi.removeGangjwa();
			
			this.updateGangjwas(source);
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
