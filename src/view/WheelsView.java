package view;

import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.Captor;
import controler.Analyser;

public class WheelsView extends Analyser{
	public JLabel label;
	
	public static ImageIcon up =  new ImageIcon("images/up.png");
	public static ImageIcon prg =  new ImageIcon("images/prg.png");
	public static ImageIcon down =  new ImageIcon("images/down.png");
	
	
	public WheelsView(){
		this.label =  new JLabel(up, SwingConstants.CENTER);
	}

	@Override
	public void update(Observable o, Object arg1) {
		// TODO Auto-generated method stub
		Captor wheel = (Captor) o;
		
		switch(wheel.name){
		case "up":
			this.label.setIcon(up);
			break;
		case "down":
			this.label.setIcon(down);
			break;
		case "prg":
			this.label.setIcon(prg);
			break;
		}
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}