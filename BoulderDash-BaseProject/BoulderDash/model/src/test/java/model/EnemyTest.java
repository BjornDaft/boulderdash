package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.dao.MapDAO;

public class EnemyTest {
	private MapDAO mapDAO;
	private IMap map;
	private Enemy enemy;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	@Before
	public void setUp() throws Exception {
		this.mapDAO = new MapDAO();
		this.enemy = new Enemy(new Position(1,1));
		char[][] t={{'O','R','O'},{'O','E','O'},{'O','O','O'}};
		this.mapDAO.setTab(t);
		this.map=mapDAO;
	}

	
	@Test
	public void testKill() {
		this.enemy.kill(this.map,1,1);
		assertEquals(this.map.getChar(1,1),this.mapDAO.getChar(1,1));
	}
}