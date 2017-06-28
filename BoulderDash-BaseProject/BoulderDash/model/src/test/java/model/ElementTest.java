package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElementTest {
	private Element element;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.element = new Rock (new Position(1,1));
	}

	@Test
	public void testGetPosition() {
		assertNotNull(this.element.position);
	}

	@Test
	public void testGetImage() {
		assertNotNull(this.element.image);
	}

	@Test
	public void testGetModelFacade() {
		assertNotNull(this.element.getModelFacade());
	}

	@Test
	public void testGravity() {
		assertNotNull(this.element.gravity);
	}
}
