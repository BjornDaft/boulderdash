package model;

public class MoveEnemy implements IMoveEnemy{
		private int x;
		private int y;
		private Ikill kill;
		@SuppressWarnings("unused")
		private boolean previousDirectionX;
		@SuppressWarnings("unused")
		private boolean previousDirectionY;
	public void move(IPosition position, IMap map, Direction direction) {
		
		x = position.getX();
		y = position.getY();

		if (map.getChar(x, y++) != 'O') {
			this.moveRight(position, map, direction);
		} else if (map.getChar(x++, y) != 'O') {
			this.moveDown(position, map, direction);
		} else if (map.getChar(x, y--) != 'O') {
			this.moveLeft(position, map, direction);
		} else if (map.getChar(x--, y) != 'O') {
			this.moveUp(position, map, direction);
		}
		if (map.getChar(x, y++) == 'O' && map.getChar(x, y--) == 'O') {
			this.VerticalMove(position, map, direction);
		}
		if (map.getChar(x++, y) == 'O' && map.getChar(x--, y) == 'O') {
			this.HorizontalMove(position, map, direction);
		}
	}
	public void moveUp(IPosition position, IMap map, Direction direction) {
		y++;
		previousDirectionY = true; // wasgoingup
		position.setY(y);
		this.kill.kill(map,x,y);
	}
	public void moveDown(IPosition position, IMap map, Direction direction) {
		y--;
		previousDirectionY = false; // wasgoingdown
		position.setY(y);
		this.kill.kill(map,x,y);
	}
	public void moveLeft(IPosition position, IMap map, Direction direction) {
		x--;
		previousDirectionX = false; // wasgoingtoleft
		position.setX(x);
		this.kill.kill(map,x,y);
	}
	public void moveRight(IPosition position, IMap map, Direction direction) {
		x++;
		previousDirectionX = true; // wasgoingtoright
		position.setX(x);
		this.kill.kill(map,x,y);
	}
	public void VerticalMove(IPosition position, IMap map, Direction direction) {
		if (previousDirectionX = true)
			y++;
		else
			y--;
		position.setY(y);
	}
	public void HorizontalMove(IPosition position, IMap map, Direction direction) {
		if (previousDirectionY = true)
			x--;
		else
			x++;
		position.setX(y);
	}
}
