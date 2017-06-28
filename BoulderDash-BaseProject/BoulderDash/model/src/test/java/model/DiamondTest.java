package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.dao.MapDAO;
	/**
	 * 
	 * @author Tristan
	 *test for diamond
	 */
public class DiamondTest {
	private Diamond diamond;
	private ICollectedDiamond behavior;
	@SuppressWarnings("unused")
	private Player player;
	private MapDAO map;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map.buildtab(1, 1, "P");
		this.diamond = new Diamond(new Position(1,1));
		this.behavior = this.diamond;
	}
	/**
	 * test for setCollectedDiamond method
	 */
	@Test
	public void testSetCollectedDiamond() {
		this.player = new Player(new Position(1,1), null);
		this.behavior.setCollectDiamond();
		assertEquals(this.diamond.getCollectDiamond(),true);
	}

}
