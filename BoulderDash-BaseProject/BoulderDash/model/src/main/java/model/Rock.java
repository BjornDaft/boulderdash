package model;

public class Rock extends Mobile{

	private int posX;
	private int posY;
	public Rock(Position position, Direction direction){
		this.posX = position.getX();
		this.posY = position.getY();

	}
	public Behavior behavior() {
		return this.behavior = new BehaviorGravity();
	}
}
