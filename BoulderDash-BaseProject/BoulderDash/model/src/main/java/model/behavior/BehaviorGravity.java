package model.behavior;

import java.util.Random;

import model.Mobile;
import model.Position;
import model.dao.ExampleDAO;

public class BehaviorGravity extends Behavior {
	private int posX;
	private int posY;
	public void behavior()
	{
	while(this.array.getChar(posX, posY) == 'X' || this.array.getChar(posX, posY++) == 'R' || this.array.getChar(posX, posY++) == 'D')  
		{
		if(this.array.getChar(posX, posY++) == 'X')
		{
			this.fallDown();
			}
		if (this.array.getChar(posX, posY++) =='R' || this.array.getChar(posX, posY++) =='D')
			{
			this.VerticalFall();
			}
		}
	}
	public void VerticalFall() {
		if(this.array.getChar(posX++, posY++) == 'X' && this.array.getChar(posX++, posY)=='X')
		{
			this.fallRight();
		}
	else if(this.array.getChar(posX--, posY++)=='X' && this.array.getChar(posX++, posY)=='X')
		{
			this.fallLeft();
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
	public void fallDown() {

		this.array.setChar(posX, posY++, 'R');
		this.array.setChar(posX, posY, 'X');
		Position.setY(posY++);
	}
	public void fallLeft() {
		this.array.setChar(posX--, posY, 'R');
		this.array.setChar(posX, posY, 'X');
		Position.setX(posX--);
	}
	public void fallRight() {
		this.array.setChar(posX++, posY, 'R');
		this.array.setChar(posX, posY, 'X');
		Position.setX(posX++);
	}
	public void randomFall() {
		Random rand =new Random();
		boolean gauche = rand.nextBoolean();
		if (gauche == true) {
			this.fallLeft();
		}
		else {
			this.fallRight();
		}
	}
}
