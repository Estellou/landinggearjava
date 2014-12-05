package controler;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//System control
public class HandleUpListener implements ChangeListener{
	
	public SystemComputer system;
	
	public HandleUpListener(SystemComputer system){
		this.system = system;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			boolean handle = (((JSlider) e.getSource()).getValue() == 0) ? false : true;
			this.system.progress(handle);
		}
	}
	
}
