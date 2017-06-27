package model;

import static org.junit.Assert.*;

//import javax.swing.text.Position;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GravityTest {
	//	@SuppressWarnings("unused")
		private Rock rock;
		@SuppressWarnings("unused")
		private Empty empty;
	//	private int x, y;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		this.rock = new Rock(new model.Position(1,1));
//		this.x = rock.position.getX();
	//	this.y = rock.position.getY();
	}

	@Test
	public void testVerticalFall() {
		fail("Not yet implemented");
	}

/*	@Test
	public void testFallDown() {
		this.empty = new Empty(new model.Position(1,2));
		this.rock.gravity(this.rock.position, this.rock.map);
		AssertTrue(this.rock.map.getChar(x, y++),'R');
	}*/
	@Test
	public void testFallLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testFallRight() {
		fail("Not yet implemented");
	}
}
