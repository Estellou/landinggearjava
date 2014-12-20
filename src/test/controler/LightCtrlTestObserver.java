package test.controler;

import model.Captor;

import org.junit.Before;
import org.junit.Test;

import controler.LightCtrl;
import controler.SystemComputer;

public class LightCtrlTestObserver {
	//setArrayGears
	//launchCommand
	//gearOnProgress
	//gearsError
	//gearsIsDown
	//gearsIsUp
	//update
	
	/*@Override
	public void update(Observable o, Object arg) {
		Captor captor = (Captor) o;
		if(captor.state) {
			switch(captor.name){
			case "open": 
				if(this.gears.get(0).dc.door.open.state & this.gears.get(1).dc.door.open.state & this.gears.get(2).dc.door.open.state) {
					this.gears.get(0).wc.update(this.command);
					this.gears.get(1).wc.update(this.command);
					this.gears.get(2).wc.update(this.command);
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
	}*/
	public Captor wheeldown;
	public Captor wheelup;
	public Captor open;
	
	public LightCtrl lc;
	
	@Before
	public void initialize(){
		this.lc = new LightCtrl();
	/*case "wheeldown":
	case "wheelup":
	case "open": */
		this.wheeldown = new Captor("wheeldown", false);
		this.wheelup = new Captor("wheelup", false);
		this.open = new Captor("open", false);
		wheeldown.addObserver(lc);
		wheelup.addObserver(lc);
		open.addObserver(lc);
		
		/*SystemComputer gearSystem1 = new SystemComputer("gear1");
		SystemComputer gearSystem2 = new SystemComputer("gear2");
		SystemComputer gearSystem3 = new SystemComputer("gear3");*/
		
		//lc.setArrayGears(gearSystem1, gearSystem2, gearSystem3);
		
	}
	
	@Test
	public void AfterOpenedDoor(){
		
	}
	
}
