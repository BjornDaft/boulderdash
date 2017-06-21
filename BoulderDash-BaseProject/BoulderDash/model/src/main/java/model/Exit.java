package model;

import model.behavior.*;

public class Exit extends Statics{

	private static String IMAGE="Exit";
	private boolean open=false
	private static int expectedDiamond;
	public Exit(Position position){
		this.posX = position.getX();
		this.posY = position.getY();
		this.position = new Position(posX, posY); 
	}
	public Behavior behavior() {
		return this.behavior = new model.behavior.BehaviorExit();
	}
	public static int getExpectedDiamond() {
		return expectedDiamond;
	}

}
