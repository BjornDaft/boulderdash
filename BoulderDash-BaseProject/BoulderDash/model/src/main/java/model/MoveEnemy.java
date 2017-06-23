package model;

public class MoveEnemy implements IMove{
	/**
	 * @author Tristan Lefèvre - Julien His
	 * <h6>description</h6>
	 * class from Move behavior.
	 * this move is used by the enemy
	 * 
	 * the move enemy check the player's direction and priorize to turning left
	**/
		private int x;
		private int y;
		@SuppressWarnings("unused")
		private boolean previousDirectionX;
		@SuppressWarnings("unused")
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
	/**
	 *  enemy go to up
	 **/
	public void moveUp(Position position, Array array, Direction direction) {
		y++;
		previousDirectionY = true; // wasgoingup
		position.setY(y);
	}
	/**
	 *  enemy go to down
	 **/
	public void moveDown(Position position, Array array, Direction direction) {
		y--;
		previousDirectionY = false; // wasgoingdown
		position.setY(y);
	}
	/**
	 *  enemy go to left
	 **/
	public void moveLeft(Position position, Array array, Direction direction) {
		x--;
		previousDirectionX = false; // wasgoingtoleft
		position.setX(x);
	}
	/**
	 *  enemy go to right
	 **/
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
