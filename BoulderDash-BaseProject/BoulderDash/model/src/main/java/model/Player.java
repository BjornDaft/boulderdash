package model;

import model.behavior.*;

public class Player extends Mobile{

	private int posX;
	private int posY;
	private static int collectedDiamond;
	private static boolean isAlive;
	public Player(Position position, Direction direction){
		this.posX = position.getX();
		this.posY = position.getY();

	}
	public Behavior behavior(Position position, Array array) {
		return this.behavior = new model.behavior.BehaviorPlayerAction();
	}
	public static int getCollectedDiamond() {
		// TODO Auto-generated method stub
		return collectedDiamond;
	}
	public void death(boolean isAlive) {
		if(isAlive = false ) {
			System.exit(1);
		}
	}
	public static void setIsAlive(boolean alive) {
		isAlive = alive;
	}
}
