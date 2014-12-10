package model;

import view.DoorView;

public class Door{

	public Captor open = new Captor("open", false);
	public Captor progress = new Captor("progress", false);
	public Captor close = new Captor("close", true);
	
	public Door(DoorView observer){
		open.addObserver(observer);
		progress.addObserver(observer);
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
