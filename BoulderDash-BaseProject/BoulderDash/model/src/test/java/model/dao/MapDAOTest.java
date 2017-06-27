package model.dao;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapDAOTest {
	private MapDAO map;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new MapDAO().buildtab(1, 1, "O");
	}
/*	@Before
	public void setUp() throws Exception {
	}
*/
	@Test
	public void testBuildtab() {
	
		try {	
			
		assertNotNull(this.map.getMap());
		} catch (Exception e) {
			fail("Error at generation");
		}
	}
	
	@Test
	public void testGetMap() {
		final char[][] expectedTab = {{'O'}};
		assertSame(map.getMap(), expectedTab);
	}

	@Test
	public void testSetMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetChar() {
		fail("Not yet implemented");
	}
		
	@Test
	public void testGetMap1() throws IOException {
		try {
			this.map.getMap(1);
		} catch (FileNotFoundException e) {
			fail("you've got the file?");
		} catch (SQLException e) {
			fail("Fail to connect to database");
		}
	}
}
