package test.controler;

import static org.junit.Assert.*;
import model.Door;
import model.Wheels;

import org.junit.Before;
import org.junit.Test;

import controler.LightCtrl;
import controler.SystemComputer;

public class LightCtrlTestObserver {
	
	//gearOnProgress
	//gearsError
	//gearsIsDown
	//gearsIsUp
	
	
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
	
	//gearOnProgress
	public void gearOnProgressTest(){
		
		//CAS1
		this.lc.lights.lightGreen.state = true;
		this.lc.lights.lightRed.state = false;
		this.lc.lights.lightOrange.state = false;
		
		this.lc.gearOnProgress();
		
		assertFalse(this.lc.lights.lightGreen.state);
		assertFalse(this.lc.lights.lightRed.state);
		assertTrue(this.lc.lights.lightOrange.state);
		
		//CAS2
		this.lc.lights.lightGreen.state = false;
		this.lc.lights.lightRed.state = false;
		this.lc.lights.lightOrange.state = true;
		
		this.lc.gearOnProgress();
		
		assertFalse(this.lc.lights.lightGreen.state);
		assertFalse(this.lc.lights.lightRed.state);
		assertTrue(this.lc.lights.lightOrange.state);
		
		//CAS3
		this.lc.lights.lightGreen.state = false;
		this.lc.lights.lightRed.state = false;
		this.lc.lights.lightOrange.state = false;
		
		this.lc.gearOnProgress();
		
		assertFalse(this.lc.lights.lightGreen.state);
		assertFalse(this.lc.lights.lightRed.state);
		assertTrue(this.lc.lights.lightOrange.state);
		
		//CAS4
		this.lc.lights.lightGreen.state = false;
		this.lc.lights.lightRed.state = true;
		this.lc.lights.lightOrange.state = false;
		
		this.lc.gearOnProgress();
		
		assertFalse(this.lc.lights.lightGreen.state);
		assertFalse(this.lc.lights.lightRed.state);
		assertTrue(this.lc.lights.lightOrange.state);
		
		
	}
	
	//gearsIsDown
	@Test 
	public void gearsIsDown(){
		this.lc.lights.lightGreen.state = false;
		this.lc.lights.lightOrange.state = true;
		
		this.lc.gearsIsDown();
		
		assertTrue(this.lc.lights.lightGreen.state);
		assertFalse(this.lc.lights.lightOrange.state);
	}
	
	//gearsIsUp
	@Test 
	public void gearsIsUp(){
		this.lc.lights.lightGreen.state = false;
		this.lc.lights.lightOrange.state = true;
		
		this.lc.gearsIsUp();
		
		assertFalse(this.lc.lights.lightGreen.state);
		assertFalse(this.lc.lights.lightOrange.state);
	}
	
	//gearsError
	@Test
	public void gearsErrorTest(){
		this.lc.lights.lightRed.state = false;
		this.lc.lights.lightOrange.state = true;
		
		this.lc.gearsError();
		
		assertTrue(this.lc.lights.lightRed.state);
		assertFalse(this.lc.lights.lightOrange.state);
		
	}
	
	//launch command
	@Test
	public void testlaunchCommand(){
		this.lc.launchCommand(true);
		assertTrue(this.lc.command);
		this.lc.launchCommand(false);
		assertFalse(this.lc.command);
	}
	
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
	@Test
	public void wheelDownTestWithoutError(){
		//initialisation du contexte:
		// les portes sont ouvertes.
		// on met la roue du gear1 en position finale down
		// pour déclencher la fermeture de la porte du gear1
		this.lc.errorProbability = 0;
		this.lc.gears.get(0).wc.signalError.setState(false);
		this.lc.gears.get(0).dc.door.close.state = false;
		this.lc.gears.get(1).dc.door.close.state = false;
		this.lc.gears.get(2).dc.door.close.state = false;
		
		
		this.lc.gears.get(0).dc.door.open.state = true;	
		this.lc.gears.get(1).dc.door.open.state = true;	
		this.lc.gears.get(2).dc.door.open.state = true;	
		
		//Change l'état de la porte concernée
		this.lc.gears.get(0).wc.wheels.wheelDown.setState(true);
		
		try {
			Thread.sleep(1500);
			assertTrue(this.lc.gears.get(0).dc.door.close.state);	
			assertFalse(this.lc.gears.get(1).dc.door.close.state);
			assertFalse(this.lc.gears.get(2).dc.door.close.state);
			//seul la porte du gear1 a été fermée
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void wheelDownTestWithError(){
		//initialisation du contexte:
		// les portes sont ouvertes.
		// on met la roue du gear1 en position finale down
		// pour déclencher la fermeture de la porte du gear1
		this.lc.errorProbability = 0;
		this.lc.gears.get(0).wc.signalError.setState(true);//erreur sur le gear1
		this.lc.gears.get(0).dc.door.close.state = false;
		this.lc.gears.get(1).dc.door.close.state = false;
		this.lc.gears.get(2).dc.door.close.state = false;
		
		
		this.lc.gears.get(0).dc.door.open.state = true;	
		this.lc.gears.get(1).dc.door.open.state = true;	
		this.lc.gears.get(2).dc.door.open.state = true;	
		
		//Change l'état de la porte concernée
		this.lc.gears.get(0).wc.wheels.wheelDown.setState(true);
		
		try {
			Thread.sleep(1500);
			assertFalse(this.lc.gears.get(0).dc.door.close.state);	
			assertFalse(this.lc.gears.get(1).dc.door.close.state);
			assertFalse(this.lc.gears.get(2).dc.door.close.state);
			//la porte du gear1 n'a pas été fermée car le system a détecté une erreur sur le gear1
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * case "open"
	 * 
	 */
	@Test
	public void AfterOpenedOneDoor(){
		this.lc.gears.get(0).dc.door.open.setState(true);
		this.lc.gears.get(1).dc.door.open.setState(false);
		this.lc.gears.get(2).dc.door.open.setState(false);
		//L'état d'un capteur passe à vrai, on rentre dans le case: "open"
		
		assertTrue(this.lc.gears.get(0).dc.door.open.state);
		assertFalse(this.lc.gears.get(1).dc.door.open.state);
		assertFalse(this.lc.gears.get(2).dc.door.open.state);
		
		//On doit attendre 1000s pour que le système soit à dans l'état demandé
		//si un des gears est dans l'état progress, alors le mouvement de la roue a été déclenché
		try {
			Thread.sleep(1500);
			assertFalse(this.lc.gears.get(0).wc.wheels.wheelProgress.state);
			assertFalse(this.lc.gears.get(1).wc.wheels.wheelProgress.state);
			assertFalse(this.lc.gears.get(2).wc.wheels.wheelProgress.state);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(this.lc.gears.get(0).wc.wheels.wheelProgress.state);
	}
	
	@Test
	public void AfterOpenedTwoDoors(){
		this.lc.gears.get(0).dc.door.open.setState(true);
		this.lc.gears.get(1).dc.door.open.setState(true);
		this.lc.gears.get(2).dc.door.open.setState(false);
		//L'état d'un capteur passe à vrai, on rentre dans le case: "open"
		
		assertTrue(this.lc.gears.get(0).dc.door.open.state);
		assertTrue(this.lc.gears.get(1).dc.door.open.state);
		assertFalse(this.lc.gears.get(2).dc.door.open.state);
		
		//On doit attendre 1000s pour que le système soit à dans l'état demandé
		//si un des gears est dans l'état progress, alors le mouvement de la roue a été déclenché
		try {
			Thread.sleep(1500);
			assertFalse(this.lc.gears.get(0).wc.wheels.wheelProgress.state);
			assertFalse(this.lc.gears.get(1).wc.wheels.wheelProgress.state);
			assertFalse(this.lc.gears.get(2).wc.wheels.wheelProgress.state);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void AfterOpenedThreeDoors(){
		this.lc.gears.get(0).dc.door.open.setState(true);
		this.lc.gears.get(1).dc.door.open.setState(true);
		this.lc.gears.get(2).dc.door.open.setState(true);
		//L'état d'un capteur passe à vrai, on rentre dans le case: "open"
		
		assertTrue(this.lc.gears.get(0).dc.door.open.state);
		assertTrue(this.lc.gears.get(1).dc.door.open.state);
		assertTrue(this.lc.gears.get(2).dc.door.open.state);
	
		//On doit attendre 1000s pour que le système soit à dans l'état demandé
		//si un des gears est dans l'état progress, alors le mouvement de la roue a été déclenché
		try {
			Thread.sleep(1500);
			assertTrue(this.lc.gears.get(0).wc.wheels.wheelProgress.state);
			assertTrue(this.lc.gears.get(1).wc.wheels.wheelProgress.state);
			assertTrue(this.lc.gears.get(2).wc.wheels.wheelProgress.state);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * case : Close
	 */
	//@Test
	public void CommandIsDownWithoutError(){
		//initialement toutes les portes sont fermées
		//et dans l'état up
		this.lc.command = false; //set the command down
		this.lc.errorProbability = 0;//pas d'erreur possible sur le system
		this.lc.gears.get(0).dc.door.close.state = false;
		this.lc.gears.get(1).dc.door.close.state = false;
		this.lc.gears.get(2).dc.door.close.state = false;
		//il faut juste déclencher le case close.
		this.lc.gears.get(0).dc.door.close.setState(true);
		
		try {
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			//fermeture de la deuxième porte
			this.lc.gears.get(1).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			
			//fermeture de la deuxième porte
			this.lc.gears.get(1).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			
			//fermeture de la troisième porte
			this.lc.gears.get(2).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertFalse(this.lc.lights.lightOrange.state);
			assertTrue(this.lc.lights.lightRed.state);

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@Test
	public void CommandIsDownWithError(){
		//initialement toutes les portes sont fermées
		//et dans l'état up
		this.lc.command = false; //set the command down
		this.lc.errorProbability = 0;//pas d'erreur possible sur le system
		this.lc.error = true;
		this.lc.gears.get(0).dc.door.close.state = false;
		this.lc.gears.get(1).dc.door.close.state = false;
		this.lc.gears.get(2).dc.door.close.state = false;
		
		//il faut juste déclencher le case "close".
		this.lc.gears.get(0).dc.door.close.setState(true);
		
		try {
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			//fermeture de la deuxième porte
			this.lc.gears.get(1).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			
			//fermeture de la deuxième porte
			this.lc.gears.get(1).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			
			//fermeture de la troisième porte
			this.lc.gears.get(2).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@Test
	public void CommandIsUpWithOutError(){
		//initialement toutes les portes sont fermées
		//et dans l'état up
		this.lc.command = true; //set the command down
		this.lc.errorProbability = 0;//pas d'erreur possible sur le system
		this.lc.gears.get(0).dc.door.close.state = false;
		this.lc.gears.get(1).dc.door.close.state = false;
		this.lc.gears.get(2).dc.door.close.state = false;
		
		//il faut juste déclencher le case "close".
		this.lc.gears.get(0).dc.door.close.setState(true);
		
		try {
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			//fermeture de la deuxième porte
			this.lc.gears.get(1).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			
			//fermeture de la deuxième porte
			this.lc.gears.get(1).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			
			//fermeture de la troisième porte
			this.lc.gears.get(2).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertFalse(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//@Test
	public void CommandIsUpWithError(){
		//initialement toutes les portes sont fermées
		//et dans l'état up
		this.lc.command = true; //set the command down
		this.lc.errorProbability = 0;//pas d'erreur possible sur le system
		this.lc.error = true;
		this.lc.gears.get(0).dc.door.close.state = false;
		this.lc.gears.get(1).dc.door.close.state = false;
		this.lc.gears.get(2).dc.door.close.state = false;
		
		//il faut juste déclencher le case "close".
		this.lc.gears.get(0).dc.door.close.setState(true);
		
		try {
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			//fermeture de la deuxième porte
			this.lc.gears.get(1).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			
			//fermeture de la deuxième porte
			this.lc.gears.get(1).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
			
			//fermeture de la troisième porte
			this.lc.gears.get(2).dc.door.close.setState(true);
			
			Thread.sleep(1500);
			assertFalse(this.lc.lights.lightGreen.state);
			assertTrue(this.lc.lights.lightOrange.state);
			assertFalse(this.lc.lights.lightRed.state);
	
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
}
