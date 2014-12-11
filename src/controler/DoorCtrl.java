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
	
	public void openTheDoor(){
		System.out.println("DoorCtrl: Initial State of Door: " + this.door.close.name + " "  + this.door.close.state);
		System.out.println("DoorCtrl: Initial State of Door: " + this.door.progress.name + " "  + this.door.progress.state);
		System.out.println("DoorCtrl: Initial State of Door: " + this.door.open.name + " "  + this.door.open.state);
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
	
	public void closeTheDoor(){
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
