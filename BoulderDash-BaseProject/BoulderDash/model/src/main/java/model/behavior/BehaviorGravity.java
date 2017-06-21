package model.behavior;

import java.util.Random;
import model.*;

public class BehaviorGravity extends Behavior {
	
	public void behavior(Position position, Array array)
	{
		posX = position.getX();
		posY = position.getY();
		
	while(this.array.getChar(posX, posY) == 'X' || this.array.getChar(posX, posY++) == 'R' || this.array.getChar(posX, posY++) == 'D')  
		{
		if(this.array.getChar(posX, posY++) == 'X')
		{
			this.fallDown(null);
			}
		if (this.array.getChar(posX, posY++) =='R' || this.array.getChar(posX, posY++) =='D')
			{
			this.verticalFall();
			}
		}
	}
	public void verticalFall() {
		if(this.array.getChar(posX++, posY++) == 'X' && this.array.getChar(posX++, posY)=='X')
		{
			this.fallRight(null);
		}
	else if(this.array.getChar(posX--, posY++)=='X' && this.array.getChar(posX++, posY)=='X')
		{
			this.fallLeft(null);
		}
	else if(this.array.getChar(posX--, posY++)=='X' && this.array.getChar(posX--, posY)=='X' && this.array.getChar(posX++, posY++) =='X' && this.array.getChar(posX++, posY)=='X')
		{
			this.randomFall();
		}
	else if(this.array.getChar(posX--, posY) != 'X' && this.array.getChar(posX++, posY)!='X')
		{
		return;
		}
	}
	public void fallDown(Position position) {

		this.array.setChar(posX, posY++, 'R');
		this.array.setChar(posX, posY, 'X');
		position.setY(posY ++);
	}
	public void fallLeft(Position position) {
		this.array.setChar(posX--, posY, 'R');
		this.array.setChar(posX, posY, 'X');
		position.setY(posX--);
	}
	public void fallRight(Position position) {
		this.array.setChar(posX++, posY, 'R');
		this.array.setChar(posX, posY, 'X');
		position.setX(posX++);
	}
	public void randomFall() {
		Random rand =new Random();
		boolean gauche = rand.nextBoolean();
		if (gauche == true) {
			this.fallLeft(null);
		}
		else {
			this.fallRight(null);
		}
	}
}
