package model;


public class BehaviorExplode extends Behavior {
	int i, j;
	boolean alive = false;
	public void behavior(Position position) {
		if (this.array.getChar(posX--, posY)=='P' ||this.array.getChar(posX, posY++)=='P'||this.array.getChar(posX++, posY)=='P'||this.array.getChar(posX, posY--)=='P' || this.array.getChar(posX, posY--)=='D')
		 {
		 	for(i = posX --;i <= posX ++; i++)
		 		{
		 		for(j = posY --;j <= posY ++;j ++)
		 			{
		 			this.array.setChar(i, j, 'X');
		 			}
		 		}
		 	Ennemy.setIsAlive(alive);
		 }
		
	}
}
