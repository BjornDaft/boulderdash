package model;

import model.behavior.Behavior;

public class Diamond extends Mobile{

	public Diamond(Position position){
		this.posX = position.getX();
		this.posY = position.getY();

	}
	public Behavior behavior(){
		return this.behavior = new model.behavior.BehaviorGravity();
	}
}
