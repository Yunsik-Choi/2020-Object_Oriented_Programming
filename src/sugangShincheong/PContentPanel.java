package sugangShincheong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.CResult;
import control.CShincheong;
import valueObject.VGangjwa;
import valueObject.VUser;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PSelection pSelection;
	private PMove pMove1;
	private PResult pMiridamgi;
	private PMove pMove2;
	private PResult pShincheong;
	private CResult cResult;
	private CShincheong cShincheong;
	
	private ActionListener ActionHandler;
	public PContentPanel() {
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.ActionHandler = new ActionHandler();
		
		this.pSelection = new PSelection();
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
		this.cResult = new CResult(vUser);
		this.cShincheong = new CShincheong(vUser);
		this.pSelection.initialize();
		this.pMove1.initialize();
		this.pMiridamgi.initialize(this.cShincheong.getGangjwas(vUser));
		this.pMove2.initialize();
		this.pShincheong.initialize(this.cResult.getGangjwas(vUser));
	}
	
	private Vector<VGangjwa> removeDuplicatedgangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		Vector<VGangjwa> vSingchengGangjwas= this.pShincheong.getGangjwas();
		for(int index=vSelectedGangjwas.size()-1;index>=0;index--) {
			for(VGangjwa vSingchengGangjwa: vSingchengGangjwas) {
				if(vSelectedGangjwas.size()>0&&index<vSelectedGangjwas.size()) {
					if(vSelectedGangjwas.get(index).getId().equals(vSingchengGangjwa.getId())){
						vSelectedGangjwas.remove(index);
					}
				}
			}
		}
		return vSelectedGangjwas;
	}
	private Vector<VGangjwa> removeDuplicatedShincheong(Vector<VGangjwa> vSelectedGangjwas) {
		Vector<VGangjwa> vSingchengGangjwas= this.pMiridamgi.getGangjwas();
		for(int index=vSelectedGangjwas.size()-1;index>=0;index--) {
			for(VGangjwa vSingchengGangjwa: vSingchengGangjwas) {
				if(vSelectedGangjwas.size()>0&&index<vSelectedGangjwas.size()) {
					if(vSelectedGangjwas.get(index).getId().equals(vSingchengGangjwa.getId())){
						vSelectedGangjwas.remove(index);
					}
				}
			}
		}
		return vSelectedGangjwas;
	}
	private void update(Object source) {
		Vector<VGangjwa> vSelectedGangjwas;
		if(source.equals(this.pMove1.getMoveRightButton())) {
			vSelectedGangjwas =  this.pSelection.getSelectedGangjwas();
			vSelectedGangjwas = this.removeDuplicatedgangjwas(vSelectedGangjwas);
			vSelectedGangjwas = this.removeDuplicatedShincheong(vSelectedGangjwas);
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);
			this.cShincheong.addGangjwas(vSelectedGangjwas);
		}
		else if(source.equals(this.pMove1.getMoveLeftButton())) {
			vSelectedGangjwas = this.pMiridamgi.removeGangjwa();
			this.cShincheong.removeGangjwas(vSelectedGangjwas);
		}
		else if(source.equals(this.pMove2.getMoveRightButton())) {
			vSelectedGangjwas =  this.pMiridamgi.removeGangjwa();
			this.pShincheong.addGangjwas(vSelectedGangjwas);
			this.cResult.addGangjwas(vSelectedGangjwas);
			this.cShincheong.removeGangjwas(vSelectedGangjwas);
		}else if(source.equals(this.pMove2.getMoveLeftButton())) {
			vSelectedGangjwas = this.pShincheong.removeGangjwa();
			this.pMiridamgi.addGangjwas(vSelectedGangjwas);
			this.cResult.removeGangjwas(vSelectedGangjwas);
			this.cShincheong.addGangjwas(vSelectedGangjwas);
		}
	}

	public class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			update(event.getSource());
		}
		
	}
}
