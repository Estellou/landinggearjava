package controler;

import java.util.Observable;

import model.Captor;
import view.DashBoard;

public class GeneralSystem{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SystemComputer gearSystem1;
		Captor signalError = new Captor("error", false);

		DashBoard dash = new DashBoard();
		gearSystem1 = new SystemComputer(dash.lights, dash.gearView1.wheels, dash.gearView1.door, signalError);
		
		HandleUpListener gear = new HandleUpListener(gearSystem1);
		dash.handle.addChangeListener(gear);
		
		
	}

}
