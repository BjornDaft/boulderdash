package model;

public class Mud extends Element {
	private static int IMAGEPOSITIONX = 7;
	private static int IMAGEPOSITIONY = 0;
	private int x = position.getX();
	private int y = position.getY();
	
	
	public Mud(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);

	}
	public void canBeDig(Position position, Array array){
		if (array.getType(x,y) == "Player") {
			while(array.getType(x, y) =="Player") {
				
			}
			array.setType(x, y, 'X');
		}
	}
	public void gravity(Position position, Array array) {
		
	}
}
