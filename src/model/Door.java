package model;

import view.DoorView;

public class Door{

	public Captor dooropen = new Captor("doorOpen", false);
	public Captor doorprogress = new Captor("doorProgress", false);
	public Captor doorclose = new Captor("doorClose", true);
	
	public Door(DoorView observer){
		dooropen.addObserver(observer);
		doorprogress.addObserver(observer);
		doorclose.addObserver(observer);
	}
	
	public void setStateDoorOpen(boolean state) {
		this.dooropen.setState(state);
	}
	
	public void setStateDoorProgess(boolean state) {
		this.doorprogress.setState(state);
	}
	
	public void setStateDoorClose(boolean state) {
		this.doorclose.setState(state);
	}
	
	
}
