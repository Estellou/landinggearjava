package model;

import java.util.Observable;

import view.WheelsView;
import controler.LightCtrl;
import controler.SystemComputer;

public class Wheels extends Observable {

	public Captor wheelUp;
	public Captor wheelDown;
	public Captor wheelProgress;
	

	public Wheels(String name, WheelsView observer, SystemComputer system, LightCtrl lc) {
		// initiale state
		this.wheelUp = new Captor("wheelup", true, name);
		this.wheelDown = new Captor("wheeldown", false, name);
		this.wheelProgress = new Captor("wheelprg", false, name);

		this.wheelUp.addObserver(observer);
		this.wheelUp.addObserver(system);
		this.wheelUp.addObserver(lc);
		
		this.wheelDown.addObserver(observer);
		this.wheelDown.addObserver(system);
		this.wheelDown.addObserver(lc);
		
		this.wheelProgress.addObserver(observer);
		this.wheelProgress.addObserver(lc);
	}

	public boolean afterHandle(boolean command) {

		double random = Math.random();
		if ((random * 100) >= 30) {
			// not error
			this.wheelProgress.setState(false);
			this.wheelUp.setState(command);
			if (command) {
				this.wheelDown.setState(false);
				this.wheelUp.setState(true);
			} else {
				this.wheelDown.setState(true);
				this.wheelDown.setState(false);
			}
			return true;
		}
		return false;
	}

	public void progressWheel() {
		this.wheelProgress.setState(true);
	}

}
