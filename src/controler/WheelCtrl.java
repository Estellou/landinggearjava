package controler;


import java.util.Timer;
import java.util.TimerTask;

import model.Captor;
import model.Wheels;
import view.WheelsView;
/**
 * La Class WheelCtrl permet de gérer les mouvements d'une roue
 * @author Estelle
 *
 */
public class WheelCtrl{
	
	public boolean handleUp;
	public Wheels wheels;
	public Timer timer = new Timer();
	public Captor signalError;
	public int errorProbability = 100;
	
	public boolean error = false;
	/**
	 * public constructor: on initialise les capteurs et on ajoute lightCtrl aux observers du signalError
	 * @param name
	 * @param wheelsview
	 * @param lc
	 */
	public WheelCtrl(String name, WheelsView wheelsview, LightCtrl lc){
		this.wheels = new Wheels(name, wheelsview, lc);
		this.signalError = new Captor("wheelError", false);
		this.signalError.addObserver(lc);
	}
	
	/**
	 * public constructor for testing
	 * @param name
	 */
	public WheelCtrl(String name){
		this.wheels = new Wheels(name);
		this.signalError = new Captor("wheelError", false);
	}

	public void updateWheel(boolean handleUp) {
		this.handleUp = handleUp;
		
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				WheelCtrl that = WheelCtrl.this;
				that.wheels.progressWheel(true);
			}
		}, 1000);
		
		//On déclenche le mouvement de la roue en fonction de la commande entrée
		timer.schedule(new TimerTask(){	
			@Override
			public void run() {
				WheelCtrl that = WheelCtrl.this;
				if (!that.wheels.afterHandle(that.handleUp, that.errorProbability)) {
					//si il y a une erreur sur la roue observée
					//on met alors le signalError 
					that.signalError.setState(true);
				}
			}
		},2000);
	}
}
