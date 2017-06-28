package model.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapDAOTest {
private MapDAO map;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBuildtab() {
		try {
			this.map.getMap(1);
			this.map.buildtab(3,3,"WWWWDWWWW");
		} catch (Exception e) {
			assert(e.getMessage().contains("Inexact number of chars, there are "));
		}
	}

	@Test
	public void testGetTab() {
		fail("Not yet implemented");
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
	public void testGetMap() throws SQLException {
		try {
			this.map.getMap(1);
		} catch (IOException e) {
			fail("Input/output problem");
		} catch (SQLException e) {
			fail("database error");
		}
	}

	@Test
	public void testDecrypt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGeneratelvl() {
		fail("Not yet implemented");
	}

}
