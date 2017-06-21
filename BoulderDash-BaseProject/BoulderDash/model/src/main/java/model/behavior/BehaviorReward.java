package model.behavior;

import model.Array;
import model.Player;
import model.Position;

public class BehaviorReward extends Behavior {
	int i, j;
	boolean alive = false;
	public void behavior(Position position, Array array) {
		if (array.getChar(posX--, posY)=='P' ||array.getChar(posX, posY++)=='P'||array.getChar(posX++, posY)=='P'||array.getChar(posX, posY--)=='P' ||array.getChar(posX, posY--)=='D')
		 {
		 	for(i = posX --;i <= posX ++; i++)
		 		{
		 		for(j = posY --;j <= posY ++;j ++)
		 			{
		 			if (array.getChar(i, j) == 'P') {
		 				Player.setIsAlive(false);
		 			}
		 			array.setChar(i, j, 'D');
		 			}
		 		}
		 }
	}
}