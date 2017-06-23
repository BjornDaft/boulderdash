package model;

public class Diamond extends Element implements IGravity {
	private static int IMAGEPOSITIONX = 10;
	private static int IMAGEPOSITIONY = 0;

	public Diamond(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
	}

	public void gravity() {
		this.gravity = new Gravity();
	}
}
