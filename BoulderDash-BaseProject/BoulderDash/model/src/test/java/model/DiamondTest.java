package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DiamondTest {
	private Diamond diamond;
	private ICollectedDiamond behavior;
	private Player player;
	private Exit exit;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.diamond = new Diamond(new Position(1,1));
		this.behavior = this.diamond;
	}

	@Test
	public void testSetCollectedDiamond() {
		this.player = new Player(new Position(1,1), null);
		this.behavior.setCollectDiamond();
		assertEquals(this.diamond.getCollectDiamond(),true);
	}

}
