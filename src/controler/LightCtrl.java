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
		//initialize light
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
		System.out.println("Function LIGHTCTRL : gearOnProgress");
	}
	
	public void gearsError(){
		this.lights.setLightOrange(false);
		this.lights.setLightRed(true);
		System.out.println("Function LIGHTCTRL : gearError");
	}
	
	public void gearsIsDown(){
		this.lights.setLightOrange(false);
		this.lights.setLightGreen(true);
		System.out.println("Function LIGHTCTRL : gearIsDown");
	}
	
	public void gearsIsUp(){
		this.lights.setLightGreen(false);
		this.lights.setLightRed(false);
		this.lights.setLightOrange(false);
		System.out.println("Function LIGHTCTRL : gearIsUp");
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Captor captor = (Captor) o;
		if(captor.state) {
			switch(captor.name){
			case "open": 
				if(this.gears.get(0).dc.door.open.state & this.gears.get(1).dc.door.open.state & this.gears.get(2).dc.door.open.state) {
					this.gears.get(0).wc.update();
					this.gears.get(1).wc.update();
					this.gears.get(2).wc.update();
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
				System.out.println("\t\t\t SIGNAL: CAPTOR :" + captor.name);
				System.out.println("\t\t\t SIGNAL: State :" + captor.state);
				if(!this.error){
					//tous a vrai
					if(!this.gears.get(0).wc.signalError.state & !this.gears.get(1).wc.signalError.state & !this.gears.get(2).wc.signalError.state) {
						if(this.command) {
							System.out.println("(this.gearState) lc.gearIsUp \n");
							this.gearsIsUp();
						}
						else {
							System.out.println("(!this.gearState) lc.gearIsDown \n");
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
