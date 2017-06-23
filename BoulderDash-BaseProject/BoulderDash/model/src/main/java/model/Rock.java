package model;


/**
 * <h1>Rock</h1>
 * @author group 4 - Tristan Lefèvre
 * <h6>description</h6>
 * the rock class. 
 * The player can't cross it but he can push it if the frame on the other side is empty
 * The rock is affected by the gravity but not by the move. His push method move the rock depending at te player position
 */
public class Rock extends Element {
	private static int IMAGEPOSITIONX = 9;
	private static int IMAGEPOSITIONY = 0;
	@SuppressWarnings("unused")
	private int posX, posY;
	public Rock(Position position) {
		super(position,IMAGEPOSITIONX, IMAGEPOSITIONY );

	}

	@Override
	public void gravity(Position position, Array array) {
		
		this.gravity = new Gravity();
	}
	/**
	 * modify rock position depending of where the player move the rock (direction)
	**/

	public void push(Position position, Array array, Direction direction)
	{
		posX = position.getX();
		posY = position.getY();
		if(array.getType(position.getX(), position.getY()) == "Player" /*&& a gauche*/ ) {
			position.setX(posX--);
	}
		else if(array.getType(position.getX(), position.getY()) == "Player" /* && a droite*/) {
			position.setX(posX++);
		}
	}
}
