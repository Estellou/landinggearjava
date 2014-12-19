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
	 * 
	 * @param lightGreen
	 */
	public void setLightGreen(boolean lightGreen) {
		this.lightGreen.setState(lightGreen);
	}
	
	public void setLightOrange(boolean lightOrange) {
		this.lightOrange.setState(lightOrange);
	}
	
	public void setLightRed(boolean lightRed) {
		this.lightRed.setState(lightRed);
	}

}
