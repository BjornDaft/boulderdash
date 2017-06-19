package model;

public class Player extends Mobile{

	private int posX;
	private int posY;
	public Player(Position position, Direction direction){
		this.posX = position.getX();
		this.posY = position.getY();

	}
	public Behavior behavior() {
		return this.behavior = new BehaviorPlayerAction();
	}
}
