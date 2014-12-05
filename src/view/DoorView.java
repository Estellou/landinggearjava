package view;

import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Captor;
import controler.Analyser;

public class DoorView extends Analyser{
	
	public JLabel label;
	
	public static ImageIcon open = new ImageIcon("images/open.png");
	public static ImageIcon progress = new ImageIcon("images/progress.png");
	public static ImageIcon close = new ImageIcon("images/close.png");
	
	public DoorView() {
		this.label = new JLabel(" ", close, JLabel.CENTER);
	}

	@Override
	public void update(Observable o, Object arg1) {
		Captor wheel = (Captor) o;
		
		switch(wheel.name){
		case "open":
			this.label.setIcon(open);
			break;
		case "progress":
			this.label.setIcon(progress);
			break;
		case "close":
			this.label.setIcon(close);
			break;
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub	
	}

}
