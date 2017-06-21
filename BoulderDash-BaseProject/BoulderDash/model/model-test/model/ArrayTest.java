package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTest {

	private Array array = new Array(5, 5);

	@Test
	public void testGetChar() {
		try {
			char[][] tab = new char[5][5];
			tab[0][0] = 'Z';
			fail("Should throw an exception if the char isn't recognized");
		} catch (final Exception e) {
			final String expected = "getChar isnt returning the right value, the tab is corrupted";
			assertEquals(expected, e.getMessage());
		}

	}

	@Test
	public void testSetChar() {
		try {
			char[][] tab = new char[5][5];
			tab[0][0] = 'N';
			fail("Should throw an exception if the char input isnt an allowed one");
		} catch (final Exception e) {
			final String expected = "You can't set this char";
			assertEquals(expected, e.getMessage());

		}
	}
}
