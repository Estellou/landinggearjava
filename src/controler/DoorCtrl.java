package controler;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import model.Door;
import view.DoorView;

/**
 * DoorCtrl controle le mouvement de la roue
 * @author Estelle
 *
 */
public class DoorCtrl extends Observable{

	public Timer timer = new Timer();
	public Door door;
	public boolean state;
	
	/**
	 * public contructor
	 * @param doorView
	 * @param lc
	 */
	public DoorCtrl(DoorView doorView, LightCtrl lc){
		this.door = new Door(doorView, lc);
	}
	/**
	 * public constructor for testing LightCtrl
	 */
	public DoorCtrl(LightCtrl lc){
		this.door = new Door(lc);
	}
	
	/**
	 * déclenche l'ouverture de la porte après 1s
	 */
	public void openTheDoor(){
		this.door.setStateClose(false);
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				DoorCtrl that = DoorCtrl.this;
				that.door.setStateOpen(true);
			}			
		},1000);
	}
	/**
	 * déclenche la fermeture de la porte après 1s
	 */
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
