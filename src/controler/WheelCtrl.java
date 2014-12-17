package controler;


import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import model.Captor;
import model.Door;
import model.Wheels;
import view.WheelsView;

public class WheelCtrl{
	
	public boolean handleUp = true;
	public Wheels wheels;
	public Timer timer = new Timer();
	public JPanel LightsBoard;
	public Captor signalError;
	
	public boolean error = false;
	
	//TODO: Divise wheel and light
	public WheelCtrl(String name, WheelsView wheelsview ,SystemComputer system, LightCtrl lc){
		this.wheels = new Wheels(name, wheelsview, system, lc);
		this.signalError = new Captor("wheelError", false);
		this.signalError.addObserver(lc);
	}
	
	public void progress(boolean handleUp){
		this.handleUp = handleUp;
	}

	public void update() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				WheelCtrl that = WheelCtrl.this;
				that.wheels.progressWheel();
			}
		}, 1000);
		
		//On déclenche le mouvement de la roue en fonction de la commande entrée
		timer.schedule(new TimerTask(){	
			@Override
			public void run() {
				WheelCtrl that = WheelCtrl.this;
				if (that.wheels.afterHandle(that.handleUp)) {
					//on ne fait rien
					//tout s'est bien passé
					//lightCtrl prend la main qui est le system central
				} else {
					//si il y a une erreur sur la roue observée
					//on met alors le signalError 
					that.signalError.setState(true);
				}
			}
		},1000);
	}
}
