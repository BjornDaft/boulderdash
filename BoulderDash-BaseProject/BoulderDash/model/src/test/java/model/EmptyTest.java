package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmptyTest {
	private Empty empty;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		this.empty = new Empty(new Position(1,1));
	}

	@Test
	public void testGravity() {
		assertNotNull(this.empty.gravity);
	}
	@Test
	public void testMove() {
		assertNotNull(this.empty.move);
	}
}
