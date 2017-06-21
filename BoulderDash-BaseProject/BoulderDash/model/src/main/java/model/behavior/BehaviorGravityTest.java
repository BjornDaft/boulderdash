package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BehaviorGravityTest {
	private char expectedTab[][];
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		expectedTab[3][2] = 'R';
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBehavior() {
		final char tab[][] ={{'W','W','W','W','W'},{'W','X','X','R','W'},{'W','X','X','X','W'},{'W','X','X','R','W'},{'W','M','R','M','W'},{'W','W','W','W','W'}};
		assertEquals(expectedTab[3][2],tab[3][2]);
	}

}
