package controler;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Captor;
import view.GearView;
import view.LightsView;

//System control
public class HandleUpListener implements ChangeListener{
	
	public SystemComputer systemGear1;
	
	public HandleUpListener(SystemComputer systemGear1){
		this.systemGear1 = systemGear1;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			boolean handle = (((JSlider) e.getSource()).getValue() == 0) ? false : true;
			//progresss system
			this.systemGear1.launchCommand(handle);
		}
	}
	
}
