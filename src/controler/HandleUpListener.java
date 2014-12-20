package controler;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * class qui implémente ChangeListener, ici on indique au système les actions de l'utilisateur sur l'interfance (Up/Down)
 * @author Estelle
 *
 */
public class HandleUpListener implements ChangeListener{
	
	public SystemComputer systemGear1;
	public SystemComputer systemGear2;
	public SystemComputer systemGear3;
	public LightCtrl lc;
	
	public HandleUpListener(LightCtrl lc, SystemComputer systemGear1, SystemComputer systemGear2, SystemComputer systemGear3){
		this.lc = lc;
		this.systemGear1 = systemGear1;
		this.systemGear2 = systemGear2;
		this.systemGear3 = systemGear3;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			boolean handle = (((JSlider) e.getSource()).getValue() == 0) ? false : true;
			//si down handle = false
			//si up handle = true
			
			//progresss system
			this.lc.launchCommand(handle);
			this.lc.gearOnProgress();//On indique à l'interface que la commande de l'utilisateur a été prise en compte
			//lancement des différents ensembles roue/porte
			this.systemGear1.launchCommand(handle);
			this.systemGear2.launchCommand(handle);
			this.systemGear3.launchCommand(handle);
		}
	}
	
}
