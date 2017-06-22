package model;

import java.util.Random;

public abstract class Gravity extends Element {

	private int posX, posY;
	public Gravity(Position position, Array array) {
		// initialize superclass
		super(position);
	//	initialize variable
		this.posX = position.getX();
		this.posY = position.getY();
	//	begin of
		while(array.getType(posX,posY++) == "Empty" || array.getType(posX, posY++) =="Rock" || array.getType(posX,posY) =="Diamond") {
			if(array.getType(posX,posY++) == "Empty" ) {
				this.fallDown(position, array);
			}
			else if (array.getType(posX,posY++) =="Rock" || array.getType(posX,posY++) =="Diamond") {
				this.verticalFall(position, array);
			}
		}
	}
	public void verticalFall(Position position, Array array) {
	//	case where your object fall on a rock/diamond
		if(array.getType(posX++, posY++) == 'X' && array.getType(posX++, posY)=='X')
		{
			this.fallRight(position, array);
		}
	else if(array.getType(posX--, posY++)=='X' && array.getType(posX++, posY)=='X')
		{
			this.fallLeft(position, array);
		}
	else if(array.getType(posX--, posY++)=='X' && array.getType(posX--, posY)=='X' && array.getType(posX++, posY++) =='X' && array.getType(posX++, posY)=='X')
		{
			this.randomFall(position, array);
		}
	else if(array.getType(posX--, posY) != "Empty" && array.getType(posX++, posY)!="Empty")
		{
		return;
		}
	}
	public void fallDown(Position position, Array array){
	//	object fall
		this.getPosition().setY(posY++);;
	}
	public void fallLeft(Position position, Array array){
	//	object go Left
		this.getPosition().setX(posX--);
	}
	public void fallRight(Position position, Array array){
	// object go Right
		this.getPosition().setX(posX++);
	}
	public void randomFall(Position position, Array array){
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