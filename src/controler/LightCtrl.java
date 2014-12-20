package controler;

import java.util.ArrayList;
import java.util.Observable;

import model.Captor;
import model.Lights;
import view.LightsView;

public class LightCtrl extends AnalyserCaptor{
	public Lights lights;
	public ArrayList<SystemComputer> gears = new ArrayList<SystemComputer>();
	public boolean command;
	public boolean error = false;
	
	public LightCtrl(LightsView lightsview){
		this.lights = new Lights(lightsview);
		this.gearsIsUp();
	}
	
	public LightCtrl(){
		this.lights = new Lights();
		this.gearsIsUp();
	}
	
	public void setArrayGears(SystemComputer gears1, SystemComputer gears2, SystemComputer gears3 ){
		this.gears.add(gears1);
		this.gears.add(gears2);
		this.gears.add(gears3);
	}
	
	public void launchCommand(boolean command){
		this.command = command;
	}
	
	public void gearOnProgress(){
		this.lights.setLightOrange(true);
		this.lights.setLightGreen(false);
		this.lights.setLightRed(false);
	}
	
	public void gearsError(){
		this.lights.setLightOrange(false);
		this.lights.setLightRed(true);
	}
	
	public void gearsIsDown(){
		this.lights.setLightOrange(false);
		this.lights.setLightGreen(true);
	}
	
	public void gearsIsUp(){
		this.lights.setLightGreen(false);
		this.lights.setLightRed(false);
		this.lights.setLightOrange(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		Captor captor = (Captor) o;
		if(captor.state) {
			switch(captor.name){
			case "open": 
				if(this.gears.get(0).dc.door.open.state & this.gears.get(1).dc.door.open.state & this.gears.get(2).dc.door.open.state) {
					this.gears.get(0).wc.updateWheel(this.command);
					this.gears.get(1).wc.updateWheel(this.command);
					this.gears.get(2).wc.updateWheel(this.command);
				}
				break;
			case "wheeldown":
			case "wheelup":
				if(captor.gear == "gear1" & !this.gears.get(0).wc.signalError.state) this.gears.get(0).dc.closeTheDoor();
				if(captor.gear == "gear2" & !this.gears.get(1).wc.signalError.state) this.gears.get(1).dc.closeTheDoor();
				if(captor.gear == "gear3" & !this.gears.get(2).wc.signalError.state) this.gears.get(2).dc.closeTheDoor();
				break;
			case "wheelError":
				this.gearsError();
				this.error = true;
				break;
			case "close":
				if(!this.error){
					//tous a vrai
					if(!this.gears.get(0).wc.signalError.state & !this.gears.get(1).wc.signalError.state & !this.gears.get(2).wc.signalError.state) {
						if(this.command) {
							this.gearsIsUp();
						}
						else {
							this.gearsIsDown();
						}
					}	
				}
			}
		}
	}
	
	public void update(Captor captor) {
		if(captor.state) {
			switch(captor.name){
			case "open": 
				if(this.gears.get(0).dc.door.open.state & this.gears.get(1).dc.door.open.state & this.gears.get(2).dc.door.open.state) {
					this.gears.get(0).wc.updateWheel(this.command);
					this.gears.get(1).wc.updateWheel(this.command);
					this.gears.get(2).wc.updateWheel(this.command);
				}
				break;
			case "wheeldown":
			case "wheelup":
				if(captor.gear == "gear1" & !this.gears.get(0).wc.signalError.state) this.gears.get(0).dc.closeTheDoor();
				if(captor.gear == "gear2" & !this.gears.get(1).wc.signalError.state) this.gears.get(1).dc.closeTheDoor();
				if(captor.gear == "gear3" & !this.gears.get(2).wc.signalError.state) this.gears.get(2).dc.closeTheDoor();
				break;
			case "wheelError":
				this.gearsError();
				this.error = true;
				break;
			case "close":
				if(!this.error){
					//tous a vrai
					if(!this.gears.get(0).wc.signalError.state & !this.gears.get(1).wc.signalError.state & !this.gears.get(2).wc.signalError.state) {
						if(this.command) {
							this.gearsIsUp();
						}
						else {
							this.gearsIsDown();
						}
					}	
				}
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
