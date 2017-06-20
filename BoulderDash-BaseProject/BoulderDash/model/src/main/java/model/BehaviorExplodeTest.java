package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BehaviorExplodeTest {
	private char expectedTab[][];
	private int j, i;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		expectedTab[j][i] ='X' ;//{{'W','W','W','W','W'},{'W','X','X','X','W'},{'W','X','X','X','W'},{'W','X','X','X','W'},{'W','W','W','W','W'}};
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBehavior() {
		final char tab[][]= {{'W','W','W','W','W'},{'W','O','P','O','W'},{'W','O','E','O','W'},{'W','O','O','O','W'},{'W','W','W','W','W'}};
		for(j=1; j<3; j ++) {
			for(i=1; i<3; i++) {
				assertEquals(expectedTab[j][i],tab[j][i]);
			}
		}
	}
}
