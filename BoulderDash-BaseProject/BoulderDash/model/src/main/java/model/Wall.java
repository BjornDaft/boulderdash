package model;

public class Wall extends Element {
	private static int IMAGEPOSITIONX = 6;
 private static int IMAGEPOSITIONY = 0;


	public Wall(Position position, final int imagePositionX, final int imagePositionY){
		super(position, IMAGEPOSITIONX,IMAGEPOSITIONY );
	}
}
