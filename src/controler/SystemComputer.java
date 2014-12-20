package controler;

import view.DoorView;
import view.WheelsView;

/**
 * Class permettant de rassembler une roue et une porte
 * @author Estelle
 *
 */
public class SystemComputer{
	public WheelCtrl wc;
	public DoorCtrl dc;
	public boolean gearState = true;
	
	/**
	 * plubic constructeur initialisation de la roue et de la porte
	 * @param name
	 * @param lc
	 * @param wv
	 * @param dv
	 */
	public SystemComputer(String name, LightCtrl lc, WheelsView wv, DoorView dv){
		this.wc = new WheelCtrl(name, wv, lc);
		this.dc = new DoorCtrl(dv, lc);
	}
	/**
	 * public constructor for testing
	 * @param name
	 */
	public SystemComputer(String name, LightCtrl lc){
		this.wc = new WheelCtrl(name, lc);
		this.dc = new DoorCtrl(lc);
	}
	/**
	 * Lancer le mouvement de l'ensemble. Pour cela, il faut commencer par ouvrir la porte.
	 * @param handle
	 */
	public void launchCommand(boolean handle){
		this.gearState = handle;
		this.dc.openTheDoor();
	}
}
