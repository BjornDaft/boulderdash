package model;

public class Diamond extends Element implements IGravity, ICollectedDiamond{
	private static int IMAGEPOSITIONX = 10;
	private static int IMAGEPOSITIONY = 0;
	private boolean collected = false;
	private IExit exit;
	public Diamond(IPosition position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.gravity();
		this.move();
	}

	public void gravity() {
		if (collected = true) {
		this.gravity = new Gravity();
		}
	}
	public void move() {
		new NoMove();
	}
	public void setCollectDiamond() {
		if (map.getChar(position.getX(), position.getY()) == 'P' && collected == false) {
			this.exit.setCollectedDiamond();
			this.exit.state(map);
			collected = true;
		}
	}
	public boolean getCollectDiamond() {
		return collected;
	}
}
