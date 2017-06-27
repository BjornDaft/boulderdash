package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MudTest {
	private Mud mud;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mud = new Mud(new Position(1,1));
		this.mud.setDig(false);
	}

/*	@Test
	public void testCanBeDig() {
		new Player (new Position(1,1), null);
		this.mud.canBeDig(this.mud.array);
		assertEquals(true, this.mud.getDig());
	}
*/
	@Test
	public void testGetDig() {
		assertEquals(false, this.mud.getDig());
	}
	@Test
	public void testSetDig() {
		boolean newDig = true;
		this.mud.setDig(newDig);
		assertEquals(true, this.mud.getDig());
	}
}
