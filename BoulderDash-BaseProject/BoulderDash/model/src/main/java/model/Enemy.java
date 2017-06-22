package model;



public class Enemy extends Element implements IMove {
	private static int IMAGEPOSITIONX = 16;
	private static int IMAGEPOSITIONY = 1;
	private Position position;
	
	public Enemy(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.position = position;
	}

	@Override
	public void move() {

		int x = position.getX();
		int y = position.getY();
		Boolean previousDirectionX;
		Boolean previousDirectionY;
		
		if(array.getType(x, y++) != "Avoid"){
			x++;
			previousDirectionX = true; //wasgoingtoright
			position.setX(x);
		}
		else if(array.getType(x++, y) != "Avoid"){
			y--;
			previousDirectionY = false; //wasgoingdown
			position.setY(y);
		}
		else if(array.getType(x, y--) != "Avoid"){
			x--;
			previousDirectionX = false; //wasgoingtoleft
			position.setX(x);
		}
		else if(array.getType(x--, y) != "Avoid"){
			y++;
			previousDirectionY = true; //wasgoingup
			position.setY(y);
		}
		if(array.getType(x, y++) == "Avoid" && array.getType(x, y--) == "Avoid"){
			if(previousDirectionX = true)
				y++;
			else
				y--;
			position.setY(y);
			
	}
		if(array.getType(x++, y) == "Avoid" && array.getType(x--, y) == "Avoid"){
			if(previousDirectionY = true)
				x--;
			else
				x++;
			position.setX(y);
		}
 }
}
