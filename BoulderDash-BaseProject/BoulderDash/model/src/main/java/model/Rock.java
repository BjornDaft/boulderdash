package model;



public class Rock extends Element {
	private static int IMAGEPOSITIONX = 9;
	private static int IMAGEPOSITIONY = 0;
	public Rock(Position position) {
		super(position,IMAGEPOSITIONX, IMAGEPOSITIONY );

	}

	@Override
	public void gravity(Position position, Array array) {
		
		this.gravity = new Gravity();
	}
	public void push(Position position, Array array)
	{
		if Player.getDirection == Left) {
			
		}
	}
}
