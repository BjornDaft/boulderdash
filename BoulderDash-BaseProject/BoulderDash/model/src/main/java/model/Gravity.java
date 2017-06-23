package model;

import java.util.Random;

public class Gravity implements IGravity {

	private int posX, posY;
	public void gravity(Position position, Array array) {
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
		if(array.getType(posX++, posY++) == "Empty" && array.getType(posX++, posY)=="Empty")
		{
			this.fallRight(position, array);
		}
	else if(array.getType(posX--, posY++)=="Empty" && array.getType(posX++, posY)=="Empty")
		{
			this.fallLeft(position, array);
		}
	else if(array.getType(posX--, posY++)=="Empty" && array.getType(posX--, posY)=="Empty" && array.getType(posX++, posY++) =="Empty" && array.getType(posX++, posY)=="Empty")
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
		position.setY(posY++);;
	}
	public void fallLeft(Position position, Array array){
	//	object go Left
		position.setX(posX--);
	}
	public void fallRight(Position position, Array array){
	// object go Right
		position.setX(posX++);
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