package view;

import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Captor;

import controler.Analyser;

public class LightsView extends Analyser{
	public JLabel label1;
	public JLabel label2;
	public JLabel label3;

	public static ImageIcon green = new ImageIcon("images/green.jpg");
	public static ImageIcon red = new ImageIcon("images/red.jpg");
	public static ImageIcon orange = new ImageIcon("images/orange.jpg");
	public static ImageIcon none = new ImageIcon("images/none.jpg");

	public LightsView() {
		this.label1 = new JLabel(" ", none, JLabel.CENTER);
		this.label2 = new JLabel(" ", none, JLabel.CENTER);
		this.label3 = new JLabel(" ", none, JLabel.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		/**Captor lightChanged = (Captor) arg.getClass();**/
		Captor l = (Captor) o;
		
		switch(l.name){
		case "lightGreen":
			if (l.state) {
				this.label3.setIcon(green);
			} else {
				this.label3.setIcon(none);
			}
			break;
		case "lightRed":
			if (l.state) {
				this.label1.setIcon(red);
			} else {
				this.label1.setIcon(none);
			}
			break;
		case "lightOrange":
			if (l.state) {
				this.label2.setIcon(orange);
			} else {
				this.label2.setIcon(none);
			}
			break;
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

}
