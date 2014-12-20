package controler;

import view.DashBoard;

/**Main Class
 *  Ici est lancé le system
**/

public class GeneralSystem{
	
	public static void main(String[] args) {
		DashBoard dash = new DashBoard();
		LightCtrl lc = new LightCtrl(dash.lights);
		
		SystemComputer gearSystem1 = new SystemComputer("gear1", lc , dash.gearView1.wheels, dash.gearView1.door);
		SystemComputer gearSystem2 = new SystemComputer("gear2", lc, dash.gearView2.wheels, dash.gearView2.door);
		SystemComputer gearSystem3 = new SystemComputer("gear3", lc, dash.gearView3.wheels, dash.gearView3.door);
		
		lc.setArrayGears(gearSystem1, gearSystem2, gearSystem3);
		
		HandleUpListener gear = new HandleUpListener(lc, gearSystem1, gearSystem2, gearSystem3);
		dash.handle.addChangeListener(gear);
	}
	
}

