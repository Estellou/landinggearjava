package model;

import view.DoorView;
import controler.LightCtrl;

/**
 * Class  Door compos�e de Captor.
 * @author Estelle
 *
 */
public class Door{
	
	public Captor open = new Captor("open", false);
	public Captor progress = new Captor("progress", false);
	public Captor close = new Captor("close", true);
	/**
	 * Door public constructor: ajout des observers aux capteurs
	 * @param observer
	 * @param lc
	 */
	public Door(DoorView observer, LightCtrl lc){
		open.addObserver(observer);
		open.addObserver(lc);
		
		progress.addObserver(observer);
		progress.addObserver(lc);
		
		close.addObserver(observer);
		close.addObserver(lc);
	}
	/**
	 * public constructor for testing LightCtrl
	 * 
	 */
	public Door(LightCtrl lc){
		open.addObserver(lc);
		progress.addObserver(lc);
		close.addObserver(lc);
	}
	/**
	 * public constructor for testing
	 * 
	 */
	public Door(){
	
	}
	/**
	 * setter du capteur � utilisiser lorsque la porte est en mode ouverte
	 * @param state
	 */
	public void setStateOpen(boolean state) {
		this.open.setState(state);
	}
	/**
	 * setter du capteur � utilisiser lorsque la porte est en progression (ouverture/ferm�e)
	 * @param state
	 */
	public void setStateProgress(boolean state) {
		this.progress.setState(state);
	}
	/**
	 * setter du capteur � utilisiser lorsque la porte est en mode ferm�e
	 * @param state
	 */
	public void setStateClose(boolean state) {
		this.close.setState(state);
	}
	
	
	
	
}
