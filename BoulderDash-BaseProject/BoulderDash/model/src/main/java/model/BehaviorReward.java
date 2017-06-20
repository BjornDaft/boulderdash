package model;

public class BehaviorReward extends Behavior {
	int tposX, tposY;
	public void behavior() 
	{
		if (tab[posX--][posY] ="P" || tab[posX ++][posY] =="P" || tab[posX][posY ++] =="P" || tab[posX][posY --] =="P" || tab[posX][posY --] =="R")
		 {
		 	for(tposX = posX --,tposX =posX ++, tposX ++)
		 		{
		 		for(tposY = posY --,tposY =posY ++, tposY ++)
		 			{
		 			tab[tposX][tposY] = "D";
		 			new Diamond(position);
		 			}
		 		}
		 }
		
	}
}
