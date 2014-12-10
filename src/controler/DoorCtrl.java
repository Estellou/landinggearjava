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
	
	public DoorCtrl(DoorView doorView, SystemComputer system){
		this.door = new Door(doorView, system);
	}
	
	//TODO: Warning always return true;
	public void openTheDoor(){
		this.door.setStateClose(false);
		this.door.setStateProgress(true);
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				DoorCtrl that = DoorCtrl.this;
				that.door.setStateProgress(false);
				that.door.setStateOpen(true);
			}			
		},1000);
	}
	
	//TODO: Warning always return true;
	public void closeTheDoor(){
		System.out.println("DOOR CTRL l54: Close Action");
		this.door.setStateOpen(false);
		this.door.setStateProgress(true);
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				DoorCtrl that = DoorCtrl.this;
				that.door.setStateProgress(false);
				that.door.setStateClose(true);
			}			
		},1000);
	}
}
