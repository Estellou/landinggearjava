package controler;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import model.Door;
import view.DoorView;

public class SystemDoor{

	public Timer timer = new Timer();
	public Door door;
	public boolean state;
	
	public SystemDoor(DoorView doorView){
		this.door = new Door(doorView);
	}
	
	//TODO: Warning DRINK
	/*public void mooveTheDoor(boolean order){
		if(order){//open the door
			if(this.openTheDoor()){
				setChanged();
				notifyObservers(order);
			};
		} else {//close the door
			if(this.closeTheDoor()){
				setChanged();
				notifyObservers(order);
			};
		}
		
	}*/
	
	//TODO: Warning always return true;
	public boolean openTheDoor(){
		this.door.setStateClose(false);
		this.door.setStateProgress(true);
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				SystemDoor that = SystemDoor.this;
				that.door.setStateProgress(false);
				that.door.setStateOpen(true);
			}			
		},1000);
		
		return true;
	}
	
	//TODO: Warning always return true;
	public boolean closeTheDoor(){
		this.door.setStateOpen(false);
		this.door.setStateProgress(true);
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				SystemDoor that = SystemDoor.this;
				that.door.setStateProgress(false);
				that.door.setStateClose(true);
			}			
		},4000);
		return true;
	}
}
