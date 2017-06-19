package model;

public class Player {

	private int posX;
	private int posY;
	public Player(Position position, Direction direction){
		this.posX = position.getX();
		this.posY = position.getY();

	}
}
