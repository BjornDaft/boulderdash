package model;

public class Empty extends Element {
	private static int IMAGEPOSITIONX = 8;
	private static int IMAGEPOSITIONY = 0;
	
	public Empty(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);

	}
	public void gravity(Position position, Array array) {
		this.gravity = new NoGravity();
	}
	public void move(Position position, Array array, Direction direction) {
		this.move = new NoMove();
	}
}
