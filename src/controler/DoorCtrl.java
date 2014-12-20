package controler;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import model.Door;
import view.DoorView;

public class DoorCtrl extends Observable{

	public Timer timer = new Timer();
	public Door door;
	public boolean state;
	
	public DoorCtrl(DoorView doorView, LightCtrl lc){
		this.door = new Door(doorView, lc);
	}
	/**
	 * public constructor for testing
	 */
	public DoorCtrl(){
		this.door = new Door();
	}
	
	public void openTheDoor(){
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				DoorCtrl that = DoorCtrl.this;
				that.door.setStateOpen(true);
			}			
		},1000);
	}
	
	public void closeTheDoor(){
		this.door.setStateOpen(false);
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				DoorCtrl that = DoorCtrl.this;
				that.door.setStateClose(true);
			}			
		},1000);
	}
}
