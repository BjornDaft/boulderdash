package model;

public class Enemy extends Element implements Ikill{

	/**
	 * <h1>Enemy</h1>
	 * @author group 4
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
		this.move(position, map);
		this.gravity(position, map);
		
	}
	/**
	 * <h6>target</h6>
	 * create diamond in range of 1 around enemy (diagonal include). This method work is a player is around him (diagonal excluded) or a stone is above him
	 * if a player is in range, he die.
	 **/
	public void giveDiamond(IMap map) {

		if (map.getChar(x, y--) == 'P' || map.getChar(x, y++) == 'P' || map.getChar(x++, y) == 'P'
				|| map.getChar(x--, y) == 'P' || map.getChar(x, y--) == 'R' || map.getChar(x, y--) == 'D') {
			for (x--; x == x++; x++) {
				for (y--; x == x++; x++) {
					if (map.getChar(x, y) == 'P') {
						Player.setIsAlive(false);
					}

					map.setChar(x, y, 'D');
				}
			}
		}
	}
	/**
	 * <h6>target</h6>
	 * explode and replace all object in range of 1 around enemy (diagonal include) into void. This method work if a player is around him (diagonal excluded) or a stone is above him
	 * if a player is in range, he die.
	 **/
	public void kill(IMap map) {
		if (map.getChar(x, y--) == 'P' || map.getChar(x, y++) == 'P' || map.getChar(x++, y) == 'P'
				|| map.getChar(x--, y) == 'P' || map.getChar(x, y--) == 'R' || map.getChar(x, y--) == 'D') {
			for (x--; x == x++; x++) {
				for (y--; x == x++; x++) {
					if (map.getChar(x, y) == 'P') {
						Player.setIsAlive(false);
					}

					map.setChar(x, y, 'X');
				}
			}
		}
	}

	public void gravity(IPosition position, IMap map) {
		this.gravity = new NoGravity();
	}
	public void move(IPosition position, IMap map){
		this.move = new MoveEnemy();
	}
}
