package controler;

import view.DoorView;
import view.WheelsView;

public class SystemComputer{
	public WheelCtrl wc;
	public DoorCtrl dc;
	public boolean gearState = true;
	
	public SystemComputer(String name, LightCtrl lc, WheelsView wv, DoorView dv){
		this.wc = new WheelCtrl(name, wv, lc);
		this.dc = new DoorCtrl(dv, lc);
	}
	
	public void launchCommand(boolean handle){
		this.gearState = handle;
		this.dc.openTheDoor();
	}
}
