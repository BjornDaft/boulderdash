package model;

public class Diamond extends Element implements IGravity {
	private static int IMAGEPOSITIONX = 10;
	private static int IMAGEPOSITIONY = 0;
	private boolean collected = false;
	/**
	 * @author group4
	 * <h6>description</h6>
	 * the diamond class. affected with gravity but not by move. Player need to collect if for finish the game
	**/
	public Diamond(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
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
			collected = true;
		}
	}
}
