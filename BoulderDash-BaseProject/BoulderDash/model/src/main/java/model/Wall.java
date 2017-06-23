package model;

public class Wall extends Element {
	private static int IMAGEPOSITIONX = 6;
 private static int IMAGEPOSITIONY = 0;


	public Wall(Position position){
		super(position, IMAGEPOSITIONX,IMAGEPOSITIONY );
	}
	public void gravity() {
		this.gravity = new NoGravity();
	}
	public void move () {
		this.move = new NoMove();
	}
}
