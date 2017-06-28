package model;

public class Mud extends Element implements IDig {
	private static int IMAGEPOSITIONX = 7;
	private static int IMAGEPOSITIONY = 0;
	private int x = position.getX();
	private int y = position.getY();
	private boolean dig = false;
	@SuppressWarnings("unused")
	private IMoveNo move;
	
	
	public Mud(IPosition position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.gravity();
		this.move();

	}
	public void canBeDig( IMap map){
		if (map.getChar(x,y) == 'P') {
			while(map.getChar(x, y) =='P') {
				
			}
			map.setChar(x, y, 'X');
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
