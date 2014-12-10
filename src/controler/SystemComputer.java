package controler;

import java.util.Observable;

import model.Captor;
import view.DoorView;
import view.LightsView;
import view.WheelsView;

public class SystemComputer extends AnalyserCaptor{
	public WheelCtrl wc;
	public DoorCtrl dc;
	
	public SystemComputer(LightsView lv, WheelsView wv, DoorView dv){
		this.wc = new WheelCtrl(lv, wv, this);
		this.dc = new DoorCtrl(dv, this);
	}
	
	public void launchCommand(boolean handle){
		this.wc.progress(handle);
		this.dc.openTheDoor();
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Captor door = (Captor) o;
		if(door.state) {
			switch(door.name){
				case "open":
					System.out.println("=>open door");
					this.wc.update();
					break;
			
				case "wheeldown":
				case "wheelup":
					System.out.println("=>close door");
					//move the wheel;
					this.dc.closeTheDoor();
					break;
			}
		}	
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
