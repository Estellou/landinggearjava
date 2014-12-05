package controler;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import model.Lights;
import model.Wheels;
import view.LightsView;
import view.WheelsView;

public class SystemComputer{
	public Lights lights;
	public boolean handleUp = true;
	public Wheels wheels;
	public Timer timer = new Timer();
	public JPanel LightsBoard;
	
	public SystemComputer(LightsView lightsview, WheelsView wheelsview){
		this.lights = new Lights(lightsview);
		this.wheels = new Wheels(wheelsview);
	}
	
	public void progress(boolean handleUp){
		
		this.handleUp = handleUp;

		if (this.wheels.progressWheel()) {
			this.lights.setLightGreen(false);
			this.lights.setLightRed(false);
			this.lights.setLightOrange(true);
			timer.schedule(new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					SystemComputer that = SystemComputer.this;
					that.lights.setLightOrange(false);
					if (that.wheels.afterHandle(that.handleUp)) {
						if (!that.handleUp) {//system down
							that.lights.setLightGreen(true);
						}
					} else {//erreur sur la roue
						that.lights.setLightRed(true);
					}
				}

			}, 1000);
			
		}
	}
}
