package model;

public class MoveEnemy implements IMove{
		private int x;
		private int y;
		private boolean previousDirectionX;
		private boolean previousDirectionY;
	public void move(Position position, Array array, Direction direction) {
		
		x = position.getX();
		y = position.getY();

		if (array.getType(x, y++) != "Avoid") {
			this.moveRight(position, array, direction);
		} else if (array.getType(x++, y) != "Avoid") {
			this.moveDown(position, array, direction);
		} else if (array.getType(x, y--) != "Avoid") {
			this.moveLeft(position, array, direction);
		} else if (array.getType(x--, y) != "Avoid") {
			this.moveUp(position, array, direction);
		}
		if (array.getType(x, y++) == "Avoid" && array.getType(x, y--) == "Avoid") {
			this.VerticalMove(position, array, direction);
		}
		if (array.getType(x++, y) == "Avoid" && array.getType(x--, y) == "Avoid") {
			this.HorizontalMove(position, array, direction);
		}
	}
	public void moveUp(Position position, Array array, Direction direction) {
		y++;
		previousDirectionY = true; // wasgoingup
		position.setY(y);
	}
	public void moveDown(Position position, Array array, Direction direction) {
		y--;
		previousDirectionY = false; // wasgoingdown
		position.setY(y);
	}
	public void moveLeft(Position position, Array array, Direction direction) {
		x--;
		previousDirectionX = false; // wasgoingtoleft
		position.setX(x);
	}
	public void moveRight(Position position, Array array, Direction direction) {
		x++;
		previousDirectionX = true; // wasgoingtoright
		position.setX(x);
	}
	public void VerticalMove(Position position, Array array, Direction direction) {
		if (previousDirectionX = true)
			y++;
		else
			y--;
		position.setY(y);
	}
	public void HorizontalMove(Position position, Array array, Direction direction) {
		if (previousDirectionY = true)
			x--;
		else
			x++;
		position.setX(y);
	}
}
