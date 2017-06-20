package model;

public class Diamond extends Mobile{

	private int posX;
	private int posY;
	public Diamond(Position position){
		this.posX = position.getX();
		this.posY = position.getY();

	}
	public Behavior behavior(){
		return this.behavior = new BehaviorGravity();
	}
}
