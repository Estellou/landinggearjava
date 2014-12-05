package model;
import java.util.Observable;

import view.WheelsView;

public class Wheels extends Observable{
	
	public Captor gearUp;
	public Captor gearDown;
	public Captor gearProgress;
	
	public Wheels(WheelsView observer){
		//initiale state
		this.gearUp = new Captor("up",true);
		this.gearDown = new Captor("down",false);
		this.gearProgress = new Captor("prg",false);
		
		this.gearUp.addObserver(observer);
		this.gearDown.addObserver(observer);
		this.gearProgress.addObserver(observer);
	}
	
	public boolean afterHandle(boolean command){

		double random = Math.random();
		if((random*100) >= 5){
			//not error
			this.gearProgress.setState(false);
			this.gearUp.setState(command);
			if(command) {
				this.gearDown.setState(false);
				this.gearUp.setState(true);
			}
			else {
				this.gearDown.setState(true);
				this.gearDown.setState(false);
			}
			
			return  true;
		} 
		return false;
	}
	
	public boolean progressWheel(){
		this.gearProgress.setState(true);
		return true;
	}
	
}
