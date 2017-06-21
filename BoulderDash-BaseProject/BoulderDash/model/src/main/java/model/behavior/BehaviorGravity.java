package model.behavior;

import java.util.Random;
import model.Position;
import model.Array;

public class BehaviorGravity extends Behavior {
	
	public void behavior(Position position, Array array)
	{
		posX = position.getX();
		posY = position.getY();
		
	while(array.getChar(posX, posY) == 'X' || array.getChar(posX, posY++) == 'R' || array.getChar(posX, posY++) == 'D')  
		{
		if(array.getChar(posX, posY++) == 'X')
		{
			this.fallDown(position, array);
			}
		if (array.getChar(posX, posY++) =='R' || array.getChar(posX, posY++) =='D')
			{
			this.verticalFall(position, array);
			}
		}
	
	}
	public void verticalFall(Position position, Array array) {
		if(array.getChar(posX++, posY++) == 'X' && array.getChar(posX++, posY)=='X')
		{
			this.fallRight(position, array);
		}
	else if(array.getChar(posX--, posY++)=='X' && array.getChar(posX++, posY)=='X')
		{
			this.fallLeft(position, array);
		}
	else if(array.getChar(posX--, posY++)=='X' && array.getChar(posX--, posY)=='X' && array.getChar(posX++, posY++) =='X' && array.getChar(posX++, posY)=='X')
		{
			this.randomFall(position, array);
		}
	else if(array.getChar(posX--, posY) != 'X' && array.getChar(posX++, posY)!='X')
		{
		return;
		}
	}
	public void fallDown(Position position, Array array) {

		array.setChar(posX, posY++, 'R');
		array.setChar(posX, posY, 'X');
		position.setY(posY ++);
	}
	public void fallLeft(Position position, Array array) {
		array.setChar(posX--, posY, 'R');
		array.setChar(posX, posY, 'X');
		position.setY(posX--);
	}
	public void fallRight(Position position, Array array) {
		array.setChar(posX++, posY, 'R');
		array.setChar(posX, posY, 'X');
		position.setX(posX++);
	}
	public void randomFall(Position position, Array array) {
		Random rand =new Random();
		boolean gauche = rand.nextBoolean();
		if (gauche == true) {
			this.fallLeft(position, array);
		}
		else {
			this.fallRight(position, array);
		}
	}
}
