package model.behavior;


public class BehaviorExplode extends Behavior {
	int i, j;
	public void behavior(Position position) {
		if (this.array.getChar(posX--, posY)=='P' ||this.array.getChar(posX, posY++)=='P'||this.array.getChar(posX++, posY)=='P'||this.array.getChar(posX, posY--)=='P' || this.array.getChar(posX, posY--)=='D')
		 {
		 	for(i = posX --;i <= posX ++; i++)
		 		{
		 		for(j = posY --;j <= posY ++;j ++)
		 			{
		 			if (this.array.getChar(i, j) == 'P') {
		 				Player.setIsAlive(false);
		 			}
		 			this.array.setChar(i, j, 'X');
		 			}
		 		}
		 	Ennemy.setIsAlive(false);
		 }
	}
}
