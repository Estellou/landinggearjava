package view;

import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Captor;
import controler.AnalyserCaptor;

public class DoorView extends AnalyserCaptor{
	
	public JLabel label;
	
	public static ImageIcon open = new ImageIcon("images/doorOpen.png");
	public static ImageIcon progress = new ImageIcon("images/doorPrg.png");
	public static ImageIcon close = new ImageIcon("images/doorClose.png");
	
	public DoorView() {
		this.label = new JLabel(" ", close, JLabel.CENTER);
	}

	@Override
	public void update(Observable o, Object arg1) {
		Captor door = (Captor) o;
		if(door.state) {
			switch(door.name){
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
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub	
	}

}
