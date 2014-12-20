package test.controler;

import static org.junit.Assert.*;
import model.Door;
import model.Wheels;

import org.junit.Before;
import org.junit.Test;

import controler.LightCtrl;
import controler.SystemComputer;

public class LightCtrlTestObserver {
	//setArrayGears
	//launchCommand
	//gearOnProgress
	//gearsError
	//gearsIsDown
	//gearsIsUp
	//update
	
	
	public Wheels wheel;
	public Door open;
	public SystemComputer gearSystem1;
	public SystemComputer gearSystem2;
	public SystemComputer gearSystem3;
	
	public LightCtrl lc;
	
	@Before
	public void initialize(){
		this.lc = new LightCtrl();
		this.wheel = new Wheels("gear1", lc);
		
		this.open = new Door(lc);
		
		this.gearSystem1 = new SystemComputer("gear1", lc);
		this.gearSystem2 = new SystemComputer("gear2", lc);
		this.gearSystem3 = new SystemComputer("gear3", lc);
		
		this.lc.setArrayGears(gearSystem1, gearSystem2, gearSystem3);
		
	}
	
	/*
	 * public void update(Captor captor) {
		if(captor.state) {
			switch(captor.name){
			case "open": 
				if(this.gears.get(0).dc.door.open.state & this.gears.get(1).dc.door.open.state & this.gears.get(2).dc.door.open.state) {
					this.gears.get(0).wc.updateWheel(this.command);
					this.gears.get(1).wc.updateWheel(this.command);
					this.gears.get(2).wc.updateWheel(this.command);
				}
				break;
			case "wheeldown":
			case "wheelup":
				if(captor.gear == "gear1" & !this.gears.get(0).wc.signalError.state) this.gears.get(0).dc.closeTheDoor();
				if(captor.gear == "gear2" & !this.gears.get(1).wc.signalError.state) this.gears.get(1).dc.closeTheDoor();
				if(captor.gear == "gear3" & !this.gears.get(2).wc.signalError.state) this.gears.get(2).dc.closeTheDoor();
				break;
			case "wheelError":
				this.gearsError();
				this.error = true;
				break;
			case "close":
				if(!this.error){
					//tous a vrai
					if(!this.gears.get(0).wc.signalError.state & !this.gears.get(1).wc.signalError.state & !this.gears.get(2).wc.signalError.state) {
						if(this.command) {
							this.gearsIsUp();
						}
						else {
							this.gearsIsDown();
						}
					}	
				}
			}
		}
	 */
	
	//setArrayGears
	@Test 
	public void testSetArrayGears(){
		this.lc.setArrayGears(this.gearSystem1, this.gearSystem1, this.gearSystem1);
		assertEquals(this.lc.gears.get(3), this.gearSystem1);
		assertEquals(this.lc.gears.get(4), this.gearSystem1);
		assertEquals(this.lc.gears.get(5), this.gearSystem1);
	}
	
	/**
	 * error
	 */
	@Test
	public void ErrorTest(){
		assertFalse(this.lc.error);
		this.lc.gears.get(0).wc.signalError.setState(true);
		assertTrue(this.lc.error);
	}
	
	/**wheelDown => fermeture de la porte concerné
	 * 
	 */
	/*@Test
	public void wheelDownTestWithoutError(){
		this.lc.gears.get(0).dc.door.close.state = false;
		this.lc.gears.get(0).dc.door.open.state = true;	
		assertFalse(this.lc.gears.get(0).dc.door.close.state);
		assertTrue(this.lc.gears.get(0).dc.door.open.state);
		assertFalse(this.wheel.wheelDown.state);
		assertTrue(this.wheel.wheelUp.state);
		this.wheel.wheelDown.setState(true);
		this.wheel.wheelUp.setState(false);
		//this.lc.gears.get(0).wc.wheels.wheelDown.setState(true);
		
		try {
			Thread.sleep(1005);
			assertTrue(this.lc.gears.get(0).dc.door.close.state);	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	@Test
	public void wheelDownTestWithError(){
		/*this.lc.gears.get(0).wc.updateWheel(false);
		assertTrue(this.lc.gears.get(0).dc.door.close.state);*/
		this.lc.gears.get(0).wc.signalError.setState(true);
		this.lc.gears.get(0).dc.door.close.state = false;
		this.lc.gears.get(0).dc.door.open.state = true;	
		assertFalse(this.lc.gears.get(0).dc.door.close.state);
		assertTrue(this.lc.gears.get(0).dc.door.open.state);
		assertFalse(this.wheel.wheelDown.state);
		assertTrue(this.wheel.wheelUp.state);
		
		this.wheel.wheelDown.setState(true);
		this.wheel.wheelUp.setState(false);
		//this.lc.gears.get(0).wc.wheels.wheelDown.setState(true);
		
		try {
			Thread.sleep(1005);
			assertFalse(this.lc.gears.get(0).dc.door.close.state);	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**case "open"
	 * 
	 */
	
	/*@Test
	public void AfterOpenedOneDoor(){
		this.lc.gears.get(0).dc.openTheDoor();
		assertFalse(this.lc.gears.get(0).dc.door.open.state);
		try {
			Thread.sleep(1000);
			assertTrue(this.lc.gears.get(0).dc.door.open.state);
			assertFalse(this.lc.gears.get(0).wc.wheels.wheelProgress.state);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(this.lc.gears.get(0).wc.wheels.wheelProgress.state);
	}*/
	
	/*@Test
	public void AfterOpenedThowDoors(){
		this.lc.gears.get(0).dc.openTheDoor();
		this.lc.gears.get(1).dc.openTheDoor();
		
		assertFalse(this.lc.gears.get(0).dc.door.open.state);
		assertFalse(this.lc.gears.get(1).dc.door.open.state);
		
		try {
			Thread.sleep(2005);
			assertTrue(this.lc.gears.get(0).dc.door.open.state);
			assertFalse(this.lc.gears.get(0).wc.wheels.wheelProgress.state);
			
			assertTrue(this.lc.gears.get(1).dc.door.open.state);
			assertFalse(this.lc.gears.get(1).wc.wheels.wheelProgress.state);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	/*@Test
	public void AfterOpenedThreeDoors(){
		this.lc.gears.get(0).dc.openTheDoor();
		this.lc.gears.get(1).dc.openTheDoor();
		this.lc.gears.get(2).dc.openTheDoor();
		
		assertFalse(this.lc.gears.get(0).dc.door.open.state);
		assertFalse(this.lc.gears.get(1).dc.door.open.state);
		assertFalse(this.lc.gears.get(2).dc.door.open.state);
		
		try {
			Thread.sleep(2005);
			assertTrue(this.lc.gears.get(0).dc.door.open.state);
			assertTrue(this.lc.gears.get(0).wc.wheels.wheelProgress.state);
			
			assertTrue(this.lc.gears.get(1).dc.door.open.state);
			assertTrue(this.lc.gears.get(1).wc.wheels.wheelProgress.state);
			
			assertTrue(this.lc.gears.get(2).dc.door.open.state);
			assertTrue(this.lc.gears.get(2).wc.wheels.wheelProgress.state);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
}
