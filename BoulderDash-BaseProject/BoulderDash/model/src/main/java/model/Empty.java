package model;

public class Empty extends Element {
	private static int IMAGEPOSITIONX = 8;
	private static int IMAGEPOSITIONY = 0;
	@SuppressWarnings("unused")
	private IMoveNo move;
	
	public Empty(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.gravity();
		this.move();

	}
	public void gravity() {
		this.gravity = new NoGravity();
	}
	public void move() {
		this.move = new NoMove();
	}
}
