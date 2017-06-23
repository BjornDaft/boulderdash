package model;

public class MoveEnemy implements IMove{
		private int x;
		private int y;
	public void move(Position position, Array array, Direction direction) {
		
		x = position.getX();
		y = position.getY();
		Boolean previousDirectionX;
		Boolean previousDirectionY;

		if (array.getType(x, y++) != "Avoid") {
			x++;
			previousDirectionX = true; // wasgoingtoright
			position.setX(x);
		} else if (array.getType(x++, y) != "Avoid") {
			y--;
			previousDirectionY = false; // wasgoingdown
			position.setY(y);
		} else if (array.getType(x, y--) != "Avoid") {
			x--;
			previousDirectionX = false; // wasgoingtoleft
			position.setX(x);
		} else if (array.getType(x--, y) != "Avoid") {
			y++;
			previousDirectionY = true; // wasgoingup
			position.setY(y);
		}
		if (array.getType(x, y++) == "Avoid" && array.getType(x, y--) == "Avoid") {
			if (previousDirectionX = true)
				y++;
			else
				y--;
			position.setY(y);

		}
		if (array.getType(x++, y) == "Avoid" && array.getType(x--, y) == "Avoid") {
			if (previousDirectionY = true)
				x--;
			else
				x++;
			position.setX(y);
		}
	}

}
