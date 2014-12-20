package test.controler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Timer;

import org.junit.Before;
import org.junit.Test;

import controler.WheelCtrl;

public class WheelCtrlTest {
	public WheelCtrl wcUp;
	public WheelCtrl wcDown;

	public Timer timer = new Timer();
	
	@Before
	public void initialize(){
		this.wcUp = new WheelCtrl("gear Up position");
		
		this.wcDown = new WheelCtrl("gear Down position");
		this.wcDown.wheels.wheelDown.state = true;
		this.wcDown.wheels.wheelUp.state = false;
		
	}
	
	/*public void updateWheel(boolean handleUp) {
		//System.out.println("WeelCTRl l57: command: "+ handleUp);
		this.handleUp = handleUp;
		
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				WheelCtrl that = WheelCtrl.this;
				that.wheels.progressWheel(true);
			}
		}, 1000);
		
		//On déclenche le mouvement de la roue en fonction de la commande entrée
		timer.schedule(new TimerTask(){	
			@Override
			public void run() {
				WheelCtrl that = WheelCtrl.this;
				if (that.wheels.afterHandle(that.handleUp, 0)) {
					//on ne fait rien
					//tout s'est bien passé
					//lightCtrl prend la main qui est le system central
					
				} else {
					//si il y a une erreur sur la roue observée
					//on met alors le signalError 
					that.signalError.setState(true);
				}
			}
		},2000);
	}*/
	
	@Test
	public void testUpdateWheelDownWithoutError(){
		this.wcUp.updateWheel(false, 0);
		
		try {
			Thread.sleep(1500);
			assertTrue(this.wcUp.wheels.wheelProgress.state);
			assertTrue(this.wcUp.wheels.wheelUp.state);
			assertFalse(this.wcUp.wheels.wheelDown.state);	
			assertFalse(this.wcUp.signalError.state);
			
			Thread.sleep(3500);
			assertFalse(this.wcUp.wheels.wheelProgress.state);
			assertFalse(this.wcUp.wheels.wheelUp.state);
			assertTrue(this.wcUp.wheels.wheelDown.state);	
			assertFalse(this.wcUp.signalError.state);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateWheelUpWithoutError(){
		this.wcDown.updateWheel(true, 0);
		
		try {
			Thread.sleep(1500);
			assertTrue(this.wcDown.wheels.wheelProgress.state);
			assertFalse(this.wcDown.wheels.wheelUp.state);
			assertTrue(this.wcDown.wheels.wheelDown.state);	
			assertFalse(this.wcDown.signalError.state);
			
			
			Thread.sleep(3500);
			assertFalse(this.wcDown.wheels.wheelProgress.state);
			assertTrue(this.wcDown.wheels.wheelUp.state);
			assertFalse(this.wcDown.wheels.wheelDown.state);	
			assertFalse(this.wcDown.signalError.state);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateWheelDownWithError(){
		this.wcUp.updateWheel(false, 101);
		
		try {
			Thread.sleep(1500);
			assertTrue(this.wcUp.wheels.wheelProgress.state);
			assertTrue(this.wcUp.wheels.wheelUp.state);
			assertFalse(this.wcUp.wheels.wheelDown.state);	
			assertFalse(this.wcUp.signalError.state);
			
			Thread.sleep(3500);
			assertTrue(this.wcUp.wheels.wheelProgress.state);
			assertTrue(this.wcUp.wheels.wheelUp.state);
			assertFalse(this.wcUp.wheels.wheelDown.state);	
			assertTrue(this.wcUp.signalError.state);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateWheelUpWithError(){
		this.wcDown.updateWheel(true, 101);
		
		try {
			Thread.sleep(1500);
			assertTrue(this.wcDown.wheels.wheelProgress.state);
			assertFalse(this.wcDown.wheels.wheelUp.state);
			assertTrue(this.wcDown.wheels.wheelDown.state);	
			assertFalse(this.wcDown.signalError.state);
			
			
			Thread.sleep(3500);
			assertTrue(this.wcDown.wheels.wheelProgress.state);
			assertFalse(this.wcDown.wheels.wheelUp.state);
			assertTrue(this.wcDown.wheels.wheelDown.state);	
			assertTrue(this.wcDown.signalError.state);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
