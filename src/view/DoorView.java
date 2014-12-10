package view;

import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Captor;
import controler.AnalyserCaptor;

public class DoorView extends AnalyserCaptor{
	
	public JLabel label;
	
	public static ImageIcon open = new ImageIcon("images/open.png");
	public static ImageIcon progress = new ImageIcon("images/progress.png");
	public static ImageIcon close = new ImageIcon("images/close.png");
	
	public DoorView() {
		this.label = new JLabel(" ", close, JLabel.CENTER);
	}

	@Override
	public void update(Observable o, Object arg1) {
		Captor door = (Captor) o;
		System.out.println("OBSERVER: Start l26 :Door View" + door.name);
		if(door.state) {
			switch(door.name){
			case "open":
				System.out.println("=>open door");
				this.label.setIcon(open);
				break;
			case "progress":
				System.out.println("=>progress door");
				this.label.setIcon(progress);
				break;
			case "close":
				System.out.println("=>close door");
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
