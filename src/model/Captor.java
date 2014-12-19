package model;

import java.util.Observable;

/**
 * Class héritant d'Observable.
 * @author Estelle
 *
 */
public class Captor extends Observable{

	public String name;
	public boolean state;
	public String gear = null;
	
	/**
	 * public constructor of Captor
	 * @param name
	 * @param state
	 * @param gear : optional parameters
	 */
	public Captor (String name, boolean state, String gear){
		this.name = name;
		this.state = state;
		this.gear = gear;
	}
	
	/**
	 * General constructor
	 * @param name
	 * @param state
	 */
	public Captor (String name, boolean state){
		this.name = name;
		this.state = state;
	}

	public String getName() {
		return name;
	}
	/**
	 * setter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter
	 * @return state
	 */
	public boolean getState() {
		return state;
	}
	/**
	 * setter avec changement notifiés à l'observer 
	 * @param state
	 */
	public void setState(boolean state) {
		this.state = state;
		setChanged();
		notifyObservers(state);
	}
	
}
