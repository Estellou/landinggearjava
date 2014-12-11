package model;

import java.util.Observable;

import view.WheelsView;
import controler.SystemComputer;

public class Wheels extends Observable {

	public Captor wheelUp;
	public Captor wheelDown;
	public Captor wheelProgress;

	public Wheels(WheelsView observer, SystemComputer system) {
		// initiale state
		this.wheelUp = new Captor("wheelup", true);
		this.wheelDown = new Captor("wheeldown", false);
		this.wheelProgress = new Captor("wheelprg", false);

		this.wheelUp.addObserver(observer);
		this.wheelUp.addObserver(system);
		
		this.wheelDown.addObserver(observer);
		this.wheelDown.addObserver(system);
		
		this.wheelProgress.addObserver(observer);
	}

	public boolean afterHandle(boolean command) {

		double random = Math.random();
		if ((random * 100) >= 5) {
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
