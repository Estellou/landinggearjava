package controler;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import model.Door;
import model.Lights;
import model.Wheels;
import view.DoorView;
import view.LightsView;
import view.WheelsView;

public class SystemComputer{
	public Lights lights;
	public boolean handleUp = true;
	public Wheels wheels;
	public Door door;
	public Timer timer = new Timer();
	public JPanel LightsBoard;
	public boolean ACCOMPLISHED = true;
	
	public SystemComputer(LightsView lightsview, WheelsView wheelsview){
		this.lights = new Lights(lightsview);
		this.wheels = new Wheels(wheelsview);
	}
	
	public void progress(boolean handleUp){
		
		this.handleUp = handleUp;
		//initialize light
		//this.door.setStateDoorOpen(false);
		this.lights.setLightGreen(false);
		this.lights.setLightRed(false);
		
		//setprogress
		this.lights.setLightOrange(true);

	}

	public boolean update() {
	
		//UPDATE LIGHT=ORANGE/WHEEL PROGRESS
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				SystemComputer that = SystemComputer.this;
				if(that.wheels.progressWheel())
				that.lights.setLightOrange(false);
			}
		}, 2000);
		System.out.println("###LIGHT AND WHEEL###");
		
		//UPDATE LIGHT/ WHEEL MOOVE
		timer.schedule(new TimerTask(){	
			@Override
			public void run() {
				SystemComputer that = SystemComputer.this;
				if (that.wheels.afterHandle(that.handleUp)) {
					if (!that.handleUp) {//system down
						that.lights.setLightGreen(true);
					}
					that.ACCOMPLISHED = true;
				} else {//si erreur sur la roue déclenché
					that.lights.setLightRed(true);
					that.ACCOMPLISHED = false;
				}
			}
		},3000);
		
		return ACCOMPLISHED;
	}
}
