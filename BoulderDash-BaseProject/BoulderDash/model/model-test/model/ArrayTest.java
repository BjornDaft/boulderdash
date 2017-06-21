package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTest {

	private Array array = new Array(5, 5);
	char tab[][];

	@Test
	public void testGetChar() {
		try {
			tab[0][0] = 'B';
			fail("getChar isnt returning thr right value");
		} catch (final Exception e) {
			final char expected = 'A';
			assertEquals(expected, e.getMessage());
		}

	}

	@Test
	public void testSetChar() {
		try {
			tab[0][0] = 'N';
			fail("Char input isnt an allowed one");
		} catch (final Exception e) {
			final char expected = 'A';
			assertEquals(expected, e.getMessage());

		}
	}
}
