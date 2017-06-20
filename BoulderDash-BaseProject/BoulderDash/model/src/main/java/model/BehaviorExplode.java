package model;



public class BehaviorExplode extends Behavior {
	int i, j;
	boolean alive = false;
	public void behavior() {
		if (tab[posX--][posY] ='P' || tab[posX ++][posY] =='P' || tab[posX][posY ++] =='P' || tab[posX][posY --] =='P' || tab[posX][posY --] =='R' || tab[posX][posY--] =='D')
		 {
		 	for(i = posX --;i = posX ++; i++)
		 		{
		 		for(tposY = posY --;tposY =posY ++; tposY ++)
		 			{
		 			tab[i][j] = "X";
		 			}
		 		}
		 	Ennemy.setIsAlive(alive);
		 }
		
	}
}
