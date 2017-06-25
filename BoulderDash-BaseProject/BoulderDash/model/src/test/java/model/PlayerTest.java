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
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Player.setIsAlive(true);
	}

	@Before
	public void setUp() throws Exception {
		player = new Player(new Position(1,1), "UP");

	}
	@Test
	public void testGravity() {
		assertNotNull(this.player.gravity);
	}
	@Test
	public void testmove() {
		assertNotNull(this.player.move);
	}
	/**
	 * test for getter getIsAlive()
	 * expected outcomes must have the same value as isAlive method
	**/
	@Test
	public void testGetIsAlive() {
		assertEquals(true ,Player.getIsAlive());
	}
	/**
	 * test for setter setIsAlive()
	 * call setIsAlive method with false at parameter
	 * expected outcome must have the same value as isAlive method
	 **/
	@Test
	public void testSetIsAlive() {
		Player.setIsAlive(false);
		assertEquals(false, Player.getIsAlive());
	}
}
