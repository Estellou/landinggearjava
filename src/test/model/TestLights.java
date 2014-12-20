package test.model;

import static org.junit.Assert.*;
import model.Lights;

import org.junit.Before;
import org.junit.Test;

public class TestLights {
	public Lights lights;
	
	@Before
	public void setVariable(){
		this.lights = new Lights();
	}
	
	@Test
	public void TestSetLightGreen(){
		this.lights.setLightGreen(true);
		assertTrue(this.lights.lightGreen.state);
		this.lights.setLightGreen(false);
		assertFalse(this.lights.lightGreen.state);
	}
	
	@Test
	public void TestSetLightRed(){
		this.lights.setLightRed(true);
		assertTrue(this.lights.lightRed.state);
		this.lights.setLightRed(false);
		assertFalse(this.lights.lightRed.state);
	}
	
	@Test
	public void TestSetLightOrange(){
		this.lights.setLightOrange(true);
		assertTrue(this.lights.lightOrange.state);
		this.lights.setLightOrange(false);
		assertFalse(this.lights.lightOrange.state);
	}
}
