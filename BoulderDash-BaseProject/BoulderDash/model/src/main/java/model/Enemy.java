package model;



public class Enemy extends Element implements IMove {
	private static int IMAGEPOSITIONX = 16;
	private static int IMAGEPOSITIONY = 1;
	
	public Enemy(Position position, final int imagePositionX, final int imagePositionY) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
 }
