package model;

import view.LightsView;

/**
 * class Lights: les lumières du tableaux de bord
 * @author Estelle
 *
 */
public class Lights {
	
	public Captor lightGreen = new Captor("lightGreen",false);
	public Captor lightOrange = new Captor("lightOrange",false);
	public Captor lightRed = new Captor("lightRed",false);
	/**
	 * Lights public constructor: ajout des observers aux capteurs
	 * @param observer
	 */
	public Lights(LightsView observer){
		this.lightGreen.addObserver(observer);
		this.lightOrange.addObserver(observer);
		this.lightRed.addObserver(observer);
	}
	/**
	 * Lights public constructor: sans ajout de l'observer pour les class de test
	 * @param observer
	 */
	public Lights(){
	}
	/**
	 * 
	 * @param state
	 */
	public void setLightGreen(boolean state) {
		this.lightGreen.setState(state);
	}
	
	public void setLightOrange(boolean state) {
		this.lightOrange.setState(state);
	}
	
	public void setLightRed(boolean state) {
		this.lightRed.setState(state);
	}

}
