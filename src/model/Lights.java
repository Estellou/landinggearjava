package model;

import view.LightsView;

public class Lights {
	
	public Captor lightGreen = new Captor("lightGreen",false);
	public Captor lightOrange = new Captor("lightOrange",false);
	public Captor lightRed = new Captor("lightRed",false);
	
	public Lights(LightsView observer){
		this.lightGreen.addObserver(observer);
		this.lightOrange.addObserver(observer);
		this.lightRed.addObserver(observer);
	}
	
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
