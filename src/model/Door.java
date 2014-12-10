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
		//TODO : add system as observer to control it
		close.addObserver(observer);
	}
	
	public void setStateOpen(boolean state) {
		this.open.setState(state);
		System.out.println("l19 : DOOR - SetStatedoorOpen");
	}
	
	public void setStateProgress(boolean state) {
		this.progress.setState(state);
		System.out.println("l24 : DOOR - SetStatedoorProgress");
	}
	
	public void setStateClose(boolean state) {
		this.close.setState(state);
		System.out.println("l29 : DOOR - SetStatedoorClose");
	}
	
	
	
	
}
