package model;

import model.behavior.Behavior;

public class Rock extends Mobile{

	private int posX;
	private int posY;
	public Rock(Position position, Direction direction){
		this.posX = position.getX();
		this.posY = position.getY();

	}
	public Behavior behavior(Position position, Array array) {
		return this.behavior = new model.behavior.BehaviorGravity();
	}
}
