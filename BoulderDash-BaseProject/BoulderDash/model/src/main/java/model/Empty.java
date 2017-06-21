package model;

public class Empty extends Element {
	private static int IMAGEPOSITIONX = 8;
	private static int IMAGEPOSITIONY = 0;
	
	public Empty(Position position, final int imagePositionX, final int imagePositionY) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);

	}
}
