package test.model;

import static org.junit.Assert.*;
import model.Wheels;

import org.junit.Before;
import org.junit.Test;

public class TestWheel {
	//dataProvider = "" après test
	//@DataProvider(name = "name")
	public Wheels w;
	@Before
	public void initializeVariable(){
		this.w = new Wheels("gear1");
	}
	
	@Test
	public void testAfterHandleUpWhitoutError(){
		boolean test = w.afterHandle(true, 0);
		assertEquals("Up and WithoutError", test, true);
		assertTrue(w.wheelUp.state);
		assertFalse(w.wheelDown.state);
		assertFalse(w.wheelProgress.state);
	}
	
	@Test
	public void testAfterHandleDownWhitoutError(){
		boolean test = w.afterHandle(false, 0);
		assertEquals("Up and WithoutError", test, true);
		assertFalse(w.wheelUp.state);
		assertTrue(w.wheelDown.state);
		assertFalse(w.wheelProgress.state);
	}
	
	@Test
	public void testAfterHandleUpWithError(){
		boolean test = w.afterHandle(true, 101);
		assertEquals("Up and WithoutError", test, false);
		assertTrue(w.wheelUp.state);
		assertFalse(w.wheelDown.state);
		assertFalse(w.wheelProgress.state);
	}
	
	@Test
	public void testAfterHandleDownWithError(){
		boolean test = w.afterHandle(true, 101);
		assertEquals("Up and WithoutError", test, false);
		assertEquals("Etat Captors Up", w.wheelUp.state, true);
		assertEquals("Etat Captors Down", w.wheelDown.state, false);
		assertEquals("Etat Captors Progress", w.wheelProgress.state, false);
	}
	
	@Test
	public void testProgressWheelTrue(){
		w.progressWheel(true);
		assertTrue(w.wheelProgress.state);
	}
	
	@Test
	public void testProgressWheelFalse(){
		w.progressWheel(false);
		assertFalse(w.wheelProgress.state);
	}
	
}
