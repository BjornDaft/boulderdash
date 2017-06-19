package model;

public class Rock {

	private int posX;
	private int posY;
	public Rock(Position position, Direction direction){
		this.posX = position.getX();
		this.posY = position.getY();

	}
}
