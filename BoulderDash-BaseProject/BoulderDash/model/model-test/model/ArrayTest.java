package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTest {

	private Array array = new Array(5, 5);

	@Test
	public void testGetChar() {
		final char expected = 'A';
		this.array.setChar(0, 0, 'A');
		assertEquals(expected, this.array.getChar(0, 0));

	}

	@Test
	public void testSetChar() {
		final char expected = 'A';
		this.array.setChar(0, 0, 'A');
		assertEquals(expected, this.array.getChar(0, 0));
		}
}
