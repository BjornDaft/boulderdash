package model;

import model.behavior.*;

public class Ennemy extends Mobile{

	private int posX;
	private int posY;
	private boolean giveReward;
	public Ennemy(Position position, Direction direction,boolean giveReward){
		this.posX = position.getX();
		this.posY = position.getY();
		this.giveReward = giveReward;

	}
	public Behavior behavior() {
		return this.behavior = new model.behavior.BehaviorEnemyMove();
	}
}
