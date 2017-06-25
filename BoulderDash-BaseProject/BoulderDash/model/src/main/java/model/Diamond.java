package model;

public class Diamond extends Element implements IGravity {
	private static int IMAGEPOSITIONX = 10;
	private static int IMAGEPOSITIONY = 0;
	private boolean collected = false;

	public Diamond(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.gravity();
		this.move();
		this.setCollectDiamond();
	}

	public void gravity() {
		if (collected = true) {
		this.gravity = new Gravity();
		}
	}
	public void move() {
		this.move = new NoMove();
	}
	public void setCollectDiamond() {
		if (array.getType(position.getX(), position.getY()) == "Player" && collected == false) {
			Exit.setCollectedDiamond();
			Exit.state(null);
			collected = true;
		}
	}
}
