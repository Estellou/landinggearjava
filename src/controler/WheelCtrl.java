package controler;


import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import model.Captor;
import model.Door;
import model.Wheels;
import view.WheelsView;

public class WheelCtrl{
	
	public boolean handleUp = true;
	public Wheels wheels;
	public Door door;
	public Timer timer = new Timer();
	public JPanel LightsBoard;
	public Captor signal;
	
	//TODO: Divise wheel and light
	public WheelCtrl(WheelsView wheelsview, Captor signal,SystemComputer system){
		this.wheels = new Wheels(wheelsview, system);
		this.signal = signal;
	}
	
	public void progress(boolean handleUp){
		//NOTE TEAMER TASK DON't WORK HERE
		this.handleUp = handleUp;
	}

	public void update() {
		//UPDATE LIGHT=ORANGE/WHEEL PROGRESS
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				WheelCtrl that = WheelCtrl.this;
				that.wheels.progressWheel();
			}
		}, 1000);
		
		//UPDATE LIGHT/ WHEEL MOOVE
		timer.schedule(new TimerTask(){	
			@Override
			public void run() {
				WheelCtrl that = WheelCtrl.this;
				if (that.wheels.afterHandle(that.handleUp)) {
					if (!that.handleUp) {//system down
						//that.lights.setLightGreen(true);
					}
				} else {//si erreur sur la roue d�clench�
						//that.lights.setLightRed(true);
					//send error
					that.signal.setState(true);
				}
			}
		},1000);
	}
}
