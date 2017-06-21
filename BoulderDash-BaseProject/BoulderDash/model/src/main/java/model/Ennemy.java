package model;

import model.behavior.*;

public class Ennemy extends Mobile{

	private boolean giveReward;
	private boolean isAlive;
	public Ennemy(Position position, Direction direction,boolean giveReward){
		this.posX = position.getX();
		this.posY = position.getY();
		this.giveReward = giveReward;

	}
	public Behavior behavior() {
		return this.behavior = new model.behavior.BehaviorEnemyMove();
	}
	public Behavior behavior(boolean giveReward) {
		if (giveReward = true) {
			isAlive = false;
			return this.behavior = new model.behavior.BehaviorReward();
		}
		else {
			isAlive = false;
			return this.behavior = new model.behavior.BehaviorExplode();
		}
		
	}
 }
