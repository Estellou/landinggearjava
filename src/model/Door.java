package model;

import view.DoorView;
import controler.LightCtrl;
import controler.SystemComputer;

public class Door{

	public Captor open = new Captor("open", false);
	public Captor progress = new Captor("progress", false);
	public Captor close = new Captor("close", true);
	
	public Door(DoorView observer, SystemComputer system, LightCtrl lc){
		open.addObserver(observer);
		open.addObserver(system);
		open.addObserver(lc);
		
		progress.addObserver(observer);
		progress.addObserver(system);
		progress.addObserver(lc);
		
		close.addObserver(observer);
		close.addObserver(system);
		close.addObserver(lc);
	}
	
	public void setStateOpen(boolean state) {
		this.open.setState(state);
	}
	
	public void setStateProgress(boolean state) {
		this.progress.setState(state);
	}
	
	public void setStateClose(boolean state) {
		this.close.setState(state);
	}
	
	
	
	
}
