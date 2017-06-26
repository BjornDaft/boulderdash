package model;

public class Diamond extends Element implements IGravity {
	private static int IMAGEPOSITIONX = 10;
	private static int IMAGEPOSITIONY = 0;
	private boolean collected = false;

	public Diamond(IPosition position) {
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
		if (map.getChar(position.getX(), position.getY()) == 'P' && collected == false) {
			Exit.setCollectedDiamond();
			Exit.state(null);
			collected = true;
		}
	}
}
