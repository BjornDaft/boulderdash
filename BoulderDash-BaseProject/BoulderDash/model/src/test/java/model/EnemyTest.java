package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EnemyTest {
	private Enemy enemy;
	private char[][] tab ={{'O','R','O'},{'O','E','O'},{'O','O','O'}};
	private Ikill behavior;
	private IMap map;
	private int x, y;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}
	@Before
	public void setUp() throws Exception {
		this.enemy = new Enemy(new Position(1,1));
		this.behavior = this.enemy;
		
	}

	@Test
	public void testKill() {
		for (x=0; x<=3; x++) {
			for (y=0; y<=3; y++) {
					this.map.setTab(tab);
				}
			}
		this.behavior.kill(map);
		assertEquals(this.enemy.map.getChar(0, 0),'X');
	}
}