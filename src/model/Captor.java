package model;

import java.util.Observable;

public class Captor  extends Observable{

	public String name;
	public boolean state;
	public String gear = null;
	
	public Captor (String name, boolean state, String gear){
		this.name = name;
		this.state = state;
		this.gear = gear;
	}
	
	public Captor (String name, boolean state){
		this.name = name;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
		setChanged();
		notifyObservers(state);
	}
	
}
