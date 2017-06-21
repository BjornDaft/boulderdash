package model;

public class Diamond extends Element implements IGravity {
	private static int IMAGEPOSITIONX = 10;
	private static int IMAGEPOSITIONY = 0;

	public Diamond(Position position, final int imagePositionX, final int imagePositionY) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
	}

	public void gravity() {

	}
}
