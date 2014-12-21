package view;

import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.AnalyserCaptor;
import model.Captor;

public class WheelsView extends AnalyserCaptor{
	public JLabel label;
	public static ImageIcon up =  new ImageIcon("images/wheelUp.png");
	public static ImageIcon prg =  new ImageIcon("images/wheelPrg.png");
	public static ImageIcon down =  new ImageIcon("images/wheelDown.png");
	
	
	public WheelsView(){
		this.label =  new JLabel(up, SwingConstants.CENTER);
	}

	@Override
	public void update(Observable o, Object arg1) {
		// TODO Auto-generated method stub
		Captor wheel = (Captor) o;
		if(wheel.state){
			switch(wheel.name){
			case "wheelup":
				this.label.setIcon(up);
				break;
			case "wheeldown":
				this.label.setIcon(down);
				break;
			case "wheelprg":
				this.label.setIcon(prg);
				break;
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
