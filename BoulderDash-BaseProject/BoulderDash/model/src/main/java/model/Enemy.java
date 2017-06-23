package model;

public class Enemy extends Element {

	private static int IMAGEPOSITIONX = 16;
	private static int IMAGEPOSITIONY = 1;
	private int x = position.getX();
	private int y = position.getY();

	public Enemy(Position position, Array array) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.position = position;
	}


	public void giveDiamond(Array array) {
		if (array.getType(x, y--) == "Player" || array.getType(x, y++) == "Player" || array.getType(x++, y) == "Player"
				|| array.getType(x--, y) == "Player" || array.getType(x, y--) == "Rock") {
			for (x--; x == x++; x++) {
				for (y--; x == x++; x++) {
					if (array.getType(x, y) == "Player") {
						// death case
					}

					array.setType(x, y, 'D');
				}
			}
		}
	}

	public void kill(Array array) {
		if (array.getType(x, y--) == "Player" || array.getType(x, y++) == "Player" || array.getType(x++, y) == "Player"
				|| array.getType(x--, y) == "Player" || array.getType(x, y--) == "Rock") {
			for (x--; x == x++; x++) {
				for (y--; x == x++; x++) {
					if (array.getType(x, y) == "Player") {
						// death case
					}

					array.setType(x, y, 'X');
				}
			}
		}
	}

	@Override
	public void gravity() {
		this.gravity = new NoGravity();
	}
	public void move(){
		this.move = new MoveEnemy();
	}
}
