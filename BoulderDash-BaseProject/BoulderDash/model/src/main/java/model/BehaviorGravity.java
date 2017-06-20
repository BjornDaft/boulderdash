package model;

import model.dao.ExampleDAO;

public class BehaviorGravity extends Behavior {

	public void behavior()
	{
	While (tab[posX][posY++] == "X" || tab[posX][posY++] == "R" || tab[posX][posY++] == "D")
		{
		if(tab[posX][posY++] = "X")
			{
			tab[posX][posY++] = "R";
			tab[posX][posY] = "X";
			setPosY(getPosY() ++);
			}
		if (tab[posX][posY++] =="R" || tab[posX][posY++] =="D")
			{
			if(tab[posX++][posY++]== "X" && tab[posX++][posY]=="X")
				{
				tab[posX++][posY]="R";
				tab[posX][posY]="X";
				posX++;
				}
			else if(tab[posX--][posY--]=="X" && tab[posX--][posY]=="X")
				{
				tab[posX][posY++]="R";
				tab[posX++][posY++]="X";
				posX--;
				}
			else if(tab[posX--][posY--]=="X" && tab[posX--][posY]=="X" )
				{

				}
			else
				{
				
				}
			}
		}
	}
}
