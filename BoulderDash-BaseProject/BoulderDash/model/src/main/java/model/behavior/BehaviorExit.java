package model.behavior;

import model.Array;
import model.Exit;
import model.Player;
import model.Position;

public class BehaviorExit extends Behavior{

	public void behavior(Position position, Array array) {
		if (Player.getCollectedDiamond() < Exit.getExpectedDiamond()) {
			Exit.setOpen(true);
			if (array.getChar(posX,posY) =='P' && Exit.getOpen() == true) {
				System.exit(1);
			}
		}
	}
}
