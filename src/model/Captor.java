package model;

import java.util.Observable;

public class Captor  extends Observable{

	public String name;
	public boolean state;
	
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
