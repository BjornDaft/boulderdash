package model;

public class Mud extends Element {
	private static int IMAGEPOSITIONX = 7;
	private static int IMAGEPOSITIONY = 0;
	private int x = position.getX();
	private int y = position.getY();
	private boolean dig = false;
	
	
	public Mud(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.canBeDig(array);
		this.gravity();
		this.move();

	}
	public void canBeDig( Array array){
		if (array.getType(x,y) == "Player") {
			while(array.getType(x, y) =="Player") {
				
			}
			array.setType(x, y, 'X');
			this.setDig(true);
		}
	}
	public void gravity() {
		this.gravity = new NoGravity();
	}
	public void move () {
		this.move = new NoMove();
	}
	public boolean getDig() {
		return dig;
	}
	public void setDig(boolean dig) {
		this.dig = dig;
	}
}
