package sugangShincheong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

		this.pSelection = new PSelection();
		this.add(this.pSelection);
		
		this.pMove1 = new PMove(this.ActionHandler);
		this.add(this.pMove1);
		
		this.pMiridamgi = new PResult("미리담기");
		JScrollPane jScrollPane1 = new JScrollPane(this.pMiridamgi);
		this.add(jScrollPane1);
		
		this.pMove2 = new PMove(this.ActionHandler);
		this.add(this.pMove2);
		
		this.pShincheong = new PResult("수강신청");
		JScrollPane jScrollPane2 = new JScrollPane(this.pShincheong);
		this.add(jScrollPane2);
	}

	public void initialize() {
		this.pSelection.initialize();
		this.pMove1.initialize();
		this.pMiridamgi.initialize();
		this.pMove2.initialize();
		this.pShincheong.initialize();
	}
	private void update(Object source) {
		Vector<VGangjwa> vGangjwas;
		if(source.equals(this.pMove1.getMoveRightButton())) {
			vGangjwas =  this.pSelection.getSelectedGangjwas();
			this.pMiridamgi.addGangjwas(vGangjwas);
		}
		else if(source.equals(this.pMove1.getMoveLeftButton())) {
			vGangjwas = this.pMiridamgi.removeGangjwa();
		}
		else if(source.equals(this.pMove2.getMoveRightButton())) {
			vGangjwas =  this.pMiridamgi.removeGangjwa();
			this.pShincheong.addGangjwas(vGangjwas);
		}else if(source.equals(this.pMove2.getMoveLeftButton())) {
			vGangjwas = this.pShincheong.removeGangjwa();
			this.pMiridamgi.addGangjwas(vGangjwas);
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
