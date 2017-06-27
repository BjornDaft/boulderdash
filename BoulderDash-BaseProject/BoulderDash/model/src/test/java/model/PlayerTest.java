package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
	/**
	 * 
	 * @author Tristan Lefevre
	 * <h6>function</h6>
	 * test player class
	 **/
public class PlayerTest {
	private Player player;
	private IPlayer behavior;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.player = new Player(new Position(1,1), "UP");
		this.behavior = this.player;
		this.behavior.setIsAlive(true);
	}
	/**
	 * test for getter getIsAlive()
	 * expected outcomes must have the same value as isAlive attribute
	**/
	@Test
	public void testGetIsAlive() {
		assertEquals(true ,this.behavior.getIsAlive());
	}
	/**
	 * test for setter setIsAlive()
	 * call setIsAlive method with false at parameter
	 * expected outcome must have the same value as isAlive method
	 **/
	@Test
	public void testSetIsAlive() {
		this.player.setIsAlive(false);
		assertEquals(false, this.behavior.getIsAlive());
	}
}
