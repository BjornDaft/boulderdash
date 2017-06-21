package model.behavior;

import model.Player;

public class BehaviorExit extends Behavior{


	public void behavior(Position position) {
		if (Player.getCollectedDiamond() < this.Map.getExpectedDiamond()) 
	}
}
