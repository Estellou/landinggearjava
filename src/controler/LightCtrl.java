package controler;

import java.util.Observable;

import model.Lights;
import view.LightsView;

public class LightCtrl extends Observable{
	public Lights lights;
	
	public LightCtrl(LightsView lightsview){
		this.lights = new Lights(lightsview);
		//initialize light
		this.gearIsUp();
	}
	
	public void gearOnProgress(){
		this.lights.setLightOrange(true);
		this.lights.setLightGreen(false);
		this.lights.setLightRed(false);
		System.out.println("gearOnProgress");
	}
	
	public void gearError(){
		this.lights.setLightOrange(false);
		this.lights.setLightRed(true);
		System.out.println("gearError");
	}
	
	public void gearIsDown(){
		this.lights.setLightOrange(false);
		this.lights.setLightGreen(true);
		System.out.println("gearIsDown");
	}
	
	public void gearIsUp(){
		this.lights.setLightGreen(false);
		this.lights.setLightRed(false);
		this.lights.setLightOrange(false);
		System.out.println("gearIsUp");
	}
	
	
}
