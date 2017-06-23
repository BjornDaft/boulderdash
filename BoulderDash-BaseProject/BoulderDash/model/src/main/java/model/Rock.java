package model;



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
