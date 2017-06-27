package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.dao.Map;

public class RockTest {
	private Rock rock;
	private IPush behavior;
	private Player player;
	private Empty empty;
	private IMap map;
	private char[][] tab = {{'R'},{'E'}};
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.rock = new Rock(new Position(1,1));
		this.behavior = this.rock;
	}

	@Test
	public void testPush() {
		this.player = new Player(new Position(1,1),"Left");
		this.empty = new Empty(new Position(1,2));
		this.behavior.push(this.rock.position, map);
		final int result = this.rock.position.getX();
		assertEquals(result, 2);
	}

}
