package controler;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.DoorView;

//System control
public class HandleUpListener implements ChangeListener{
	
	public SystemComputer wheelCtrl;
	public SystemDoor doorCtrl;
	
	public HandleUpListener(SystemComputer wheelCtrl, DoorView door){
		this.wheelCtrl = wheelCtrl;
		this.doorCtrl = new SystemDoor(door);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			boolean handle = (((JSlider) e.getSource()).getValue() == 0) ? false : true;
			this.wheelCtrl.progress(handle);
			if(this.doorCtrl.openTheDoor()){
				if(this.wheelCtrl.update()){
					this.doorCtrl.closeTheDoor();
				} else {
					//TODO: ERROR => ajouter la commande manuel
				}
			}
		}
	}
	
}
