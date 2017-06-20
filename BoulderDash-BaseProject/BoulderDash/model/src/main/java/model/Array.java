package model;

public class Array {


	private char tab[][];
		public Array(final int width, final int height) {
		this.tab = new char[width][height];
	}
		public char getChar(final int x,final int y) {
		return this.tab[x][y];
	}
		public void setChar(final int x,final int y,final char c) {
			this.tab[x][y] = c;
	}

}
