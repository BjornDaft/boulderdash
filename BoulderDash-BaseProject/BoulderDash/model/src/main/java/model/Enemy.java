package model;

public class Enemy extends Element {

	/**
	 * <h1>Enemy</h1>
	 * @author group 4 - Tristan Lefèvre
	 * <h6>description</h6>
	 * the Enemy class
	 * The enemy can kill the player with explosion. sometime, he can give diamond. Diamond and Reward range is 1 frame aroud him (diagonale include)
	 **/
	private static int IMAGEPOSITIONX = 16;
	private static int IMAGEPOSITIONY = 1;
	private int x = position.getX();
	private int y = position.getY();

	public Enemy(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.position = position;
		this.move(position, array);
		this.gravity(position, array);
		this.kill(array);
		
	}
	/**
	 * <h6>target</h6>
	 * create diamond in range of 1 around enemy (diagonal include). This method work is a player is around him (diagonal excluded) or a stone is above him
	 * if a player is in range, he die.
	 **/
	public void giveDiamond(Array array) {

		if (array.getType(x, y--) == "Player" || array.getType(x, y++) == "Player" || array.getType(x++, y) == "Player"
				|| array.getType(x--, y) == "Player" || array.getType(x, y--) == "Rock" || array.getType(x, y--) == "Diamond") {
			for (x--; x == x++; x++) {
				for (y--; x == x++; x++) {
					if (array.getType(x, y) == "Player") {
						Player.setIsAlive(false);
					}

					array.setType(x, y, 'D');
				}
			}
		}
	}
	/**
	 * <h6>target</h6>
	 * explode and replace all object in range of 1 around enemy (diagonal include) into void. This method work if a player is around him (diagonal excluded) or a stone is above him
	 * if a player is in range, he die.
	 **/
	public void kill(Array array) {
		if (array.getType(x, y--) == "Player" || array.getType(x, y++) == "Player" || array.getType(x++, y) == "Player"
				|| array.getType(x--, y) == "Player" || array.getType(x, y--) == "Rock" || array.getType(x, y--) == "Diamond") {
			for (x--; x == x++; x++) {
				for (y--; x == x++; x++) {
					if (array.getType(x, y) == "Player") {
						Player.setIsAlive(false);
					}

					array.setType(x, y, 'X');
				}
			}
		}
	}

	@Override
	public void gravity(Position position, Array array) {
		this.gravity = new NoGravity();
	}
	public void move(Position position, Array array){
		this.move = new MoveEnemy();
	}
}
