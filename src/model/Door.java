package model;

import view.DoorView;
import controler.SystemComputer;

public class Door{

	public Captor open = new Captor("open", false);
	public Captor progress = new Captor("progress", false);
	public Captor close = new Captor("close", true);
	
	public Door(DoorView observer, SystemComputer system){
		open.addObserver(observer);
		open.addObserver(system);
		
		progress.addObserver(observer);
		progress.addObserver(system);
		//TODO : add system as observer to control it
		close.addObserver(observer);
		close.addObserver(system);
	}
	
	public void setStateOpen(boolean state) {
		this.open.setState(state);
	}
	
	public void setStateProgress(boolean state) {
		this.progress.setState(state);
	}
	
	public void setStateClose(boolean state) {
		System.out.println("_In Captor Door: state door is changed__ old state = " + this.close.state);
		this.close.setState(state);
		System.out.println("_                                     __ new state = " + this.close.state);
	}
	
	
	
	
}
