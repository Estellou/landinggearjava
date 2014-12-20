package test.model;

import static org.junit.Assert.*;
import model.Door;

import org.junit.Before;
import org.junit.Test;

public class TestDoor {
	public Door door;
	
	@Before
	public void setTest(){
		this.door = new Door();
	}
	
	@Test
	public void setCaptorOpen(){
		assertFalse(this.door.open.state);
		this.door.open.setState(true);
		assertTrue(this.door.open.state);
		this.door.open.setState(false);
		assertFalse(this.door.open.state);
	}
	
	@Test
	public void setCaptorClose(){
		assertTrue(this.door.close.state);
		this.door.close.setState(false);
		assertFalse(this.door.close.state);
	}
	
	@Test
	public void setCaptorProgress(){
		assertFalse(this.door.progress.state);
		this.door.progress.setState(true);
		assertTrue(this.door.progress.state);
		this.door.progress.setState(false);
		assertFalse(this.door.progress.state);
	}
}

