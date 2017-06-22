package model;



public class Rock extends Element implements IGravity {
	private static int IMAGEPOSITIONX = 9;
	private static int IMAGEPOSITIONY = 0;
	
	public Rock(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);

	}

	@Override
	public void gravity() {
		// TODO Auto-generated method stub
		
	}
}
