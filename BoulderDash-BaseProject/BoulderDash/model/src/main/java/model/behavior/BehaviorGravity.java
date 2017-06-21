package model;

import java.util.Random;

import model.dao.ExampleDAO;

public class BehaviorGravity extends Behavior {
	
	public void behavior(Position position)
	{
	while(this.array.getChar(posX, posY++) == 'X' || this.array.getChar(posX, posY++) == 'R' || this.array.getChar(posX, posY++) == 'D')  
		{
		if(this.array.getChar(posX, posY++) == 'X')
			{
			this.array.setChar(posX, posY++, 'R');
			this.array.setChar(posX, posY, 'X');
			position.setY(posY++);
			}
		if (this.array.getChar(posX, posY++) =='R' || this.array.getChar(posX, posY++) =='D')
			{
			if(this.array.getChar(posX++, posY++) == 'X' && this.array.getChar(posX++, posY)=='X')
				{
				this.array.setChar(posX++, posY, 'R');
				this.array.setChar(posX, posY, 'X');
				posX++;
				}
			else if(this.array.getChar(posX--, posY++)=='X' && this.array.getChar(posX++, posY)=='X')
				{
				this.array.setChar(posX, posY++, 'R');
				this.array.setChar(posX++, posY++, 'X');
				posX--;
				}
			else if(this.array.getChar(posX--, posY++)=='X' && this.array.getChar(posX--, posY)=='X' && this.array.getChar(posX++, posY++) =='X' && this.array.getChar(posX++, posY)=='X')
				{
				Random rand =new Random();
				boolean gauche = rand.nextBoolean();
				if (gauche = true) {
					this.array.setChar(posX++, posY, 'R');
					this.array.setChar(posX, posY, 'X');
					posX++;
				}
				else {
					this.array.setChar(posX, posY++, 'R');
					this.array.setChar(posX++, posY++, 'X');
					posX--;
				}
				}
			else if(this.array.getChar(posX--, posY) != 'X' && this.array.getChar(posX++, posY)!='X')
				{
				break;
				}
			}
		}
	}
}
