package model;

import java.util.Random;

public class Gravity implements IGravity {
	/**
	 * @author group4
	 * 		/**
	 * <h6>description</h6>
	 * class from gravity behavior
	 * if the case under him is empty , have diamond or rock, this method start.
	 * if 
	 **/
	private int posX, posY;
	public void gravity(IPosition position, IMap map) {
	//	initialize variable
		this.posX = position.getX();
		this.posY = position.getY();
	//	begin of
		while(map.getChar(posX,posY++) == 'X' || map.getChar(posX, posY++) =='R') {
			if(map.getChar(posX,posY++) == 'X' ) {
				this.fallDown(position, map);
			}
			else if (map.getChar(posX,posY++) =='R' || map.getChar(posX,posY++) =='D') {
				this.verticalFall(position, map);
			}
			else if (map.getChar(posX, posY) == 'P')
				Player.setIsAlive(false);
		}
	}
	public void verticalFall(IPosition position, IMap map) {
	//	case where your object fall on a rock/diamond
		if(map.getChar(posX++, posY++) == 'X' && map.getChar(posX++, posY)=='X')
		{
			this.fallRight(position, map);
		}
	else if(map.getChar(posX--, posY++)=='X' && map.getChar(posX++, posY)=='X')
		{
			this.fallLeft(position, map);
		}
	else if(map.getChar(posX--, posY++)=='X' && map.getChar(posX--, posY)=='X' && map.getChar(posX++, posY++) =='X' && map.getChar(posX++, posY)=='X')
		{
			this.randomFall(position, map);
		}
	else if(map.getChar(posX--, posY) != 'X' && map.getChar(posX++, posY)!='X')
		{
		return;
		}
	}
	public void fallDown(IPosition position, IMap map){
	//	object fall
		position.setY(posY++);
		map.setChar(posX, posY, 'X');
	}
	public void fallLeft(IPosition position, IMap map){
	//	object go Left
		position.setX(posX--);
	}
	public void fallRight(IPosition position, IMap map){
	// object go Right
		position.setX(posX++);
	}
	public void randomFall(IPosition position, IMap map){
		Random rand =new Random();
		boolean gauche = rand.nextBoolean();
		if (gauche == true) {
			this.fallLeft(position, map);
		}
		else {
			this.fallRight(position, map);
		}
	}
}