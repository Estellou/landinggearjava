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
		
		this.wcDown.updateWheel(false);
		this.wcUp.updateWheel(true);
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
	
	/*@Test
	public void testUpdateWheelWithoutError(){
		try {
			Thread.sleep(1001);
			
			assertTrue(this.wcUp.wheels.wheelProgress.state);
			assertTrue(this.wcUp.wheels.wheelUp.state);
			assertFalse(this.wcUp.wheels.wheelDown.state);	
			assertFalse(this.wcUp.signalError.state);
			
			assertTrue(this.wcDown.wheels.wheelProgress.state);
			assertFalse(this.wcDown.wheels.wheelUp.state);
			assertTrue(this.wcDown.wheels.wheelDown.state);	
			assertFalse(this.wcDown.signalError.state);
			
			try {
				Thread.sleep(3001);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}*/
	
	@Test
	public void testUpdateWheelDownWithoutError(){
		
		try {
			Thread.sleep(5001);
			assertFalse(this.wcUp.wheels.wheelProgress.state);
			assertFalse(this.wcUp.wheels.wheelUp.state);
			assertTrue(this.wcUp.wheels.wheelDown.state);	
			assertFalse(this.wcUp.signalError.state);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/**@Test
	public void testUpdateWheelUpWithoutError(){
		
		this.wcDown.updateWheel(false);
		
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				WheelCtrlTest that = WheelCtrlTest.this;
				assertTrue(that.wcDown.wheels.wheelProgress.state);
				assertFalse(that.wcDown.wheels.wheelUp.state);
				assertFalse(that.wcDown.wheels.wheelDown.state);	
				assertFalse(that.wcDown.signalError.state);
			}
			
		},1000);
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				WheelCtrlTest that = WheelCtrlTest.this;
				assertFalse(that.wcDown.wheels.wheelProgress.state);
				assertTrue(that.wcDown.wheels.wheelUp.state);
				assertFalse(that.wcDown.wheels.wheelDown.state);	
				assertFalse(that.wcDown.signalError.state);
			}	},3000);
	}
	
	@Test
	public void testUpdateWheelDownWithError(){
		this.wcUp.errorProbability = 101;
		this.wcUp.updateWheel(false);
		assertFalse(this.wcUp.wheels.wheelProgress.state);
		assertTrue(this.wcUp.wheels.wheelUp.state);
		assertFalse(this.wcUp.wheels.wheelDown.state);
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				WheelCtrlTest that = WheelCtrlTest.this;
				assertTrue(that.wcUp.wheels.wheelProgress.state);
				assertTrue(that.wcUp.wheels.wheelUp.state);
				assertFalse(that.wcUp.wheels.wheelDown.state);	
				assertTrue(that.wcUp.signalError.state);
			}	
		},3000);
		
	}
	
	@Test
	public void testUpdateWheelUpWithError(){
		this.wcDown.errorProbability = 101;
		this.wcDown.updateWheel(true);
		assertFalse(this.wcDown.wheels.wheelProgress.state);
		assertFalse(this.wcDown.wheels.wheelUp.state);
		assertTrue(this.wcDown.wheels.wheelDown.state);
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				WheelCtrlTest that = WheelCtrlTest.this;
				assertFalse(that.wcDown.wheels.wheelProgress.state);
				assertFalse(that.wcDown.wheels.wheelUp.state);
				assertTrue(that.wcDown.wheels.wheelDown.state);	
				assertTrue(that.wcDown.signalError.state);
			}	},3000);
	}*/
	
	
}
