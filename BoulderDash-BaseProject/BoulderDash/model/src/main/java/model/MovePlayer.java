package model;
/**
 * @author Tristan Lefevre
 * <h6>description</h6>
 * class from Move behavior.
 * this move is used by the player
 * 
 * the move player check the player's direction
**/
public class MovePlayer implements IMove {
	public void move(IPosition position, IMap map, Direction direction) {
			switch (direction) {
				case UP:
					this.moveUp(position, map);
				break;
				case DOWN:
					this.moveDown(position, map);
				break;
				case LEFT:
					this.moveLeft(position, map);
				break;
				case RIGHT:
					this.moveRight(position, map);
				break;
			}
		}
	/**
	 * the player is go to up
 **/
		public void moveUp(IPosition position, IMap map) {
			int x = position.getX();
			int y = position.getY();
			if (map.getChar(x,y --) =='X' || map.getChar(x, y++) =='O' || map.getChar(x, y--) =='D' || map.getChar(x, y--) =='S' && Exit.getOpen() == true) {
			map.setChar(x, y --,'P');
			map.setChar(x, y, 'X');
			position.setY(y--);
			}
		}
		/**
		 * player go to down
		 **/
		public void moveDown(IPosition position, IMap map) {
			int x = position.getX();
			int y = position.getY();
			if (map.getChar(x,y ++) =='X' || map.getChar(x, y++) =='O'|| map.getChar(x, y++) =='D' || map.getChar(x, y--) =='S' && Exit.getOpen() == true) {
			map.setChar(x, y ++,'P');
			map.setChar(x, y , 'X');
			position.setY(y++);
			}
			
		}
		/**
		 * the player go to left 
	 **/
		public void moveLeft(IPosition position, IMap map) {
			int x = position.getX();
			int y = position.getY();
			if (map.getChar(x--,y) =='X' || map.getChar(x--, y) =='O' || map.getChar(x--, y) =='D' || map.getChar(x--, y) =='S' && Exit.getOpen() == true) {
			map.setChar(x--, y,'P');
			map.setChar(x, y, 'X');
			position.setY(x--);
			}
			else if(map.getChar(x--, y) =='R' && map.getChar(x-2, x) == 'X') {
				map.setChar(x--, x, 'P');
				map.setChar(x-2, x, 'R');
			}
		}
		/**
		 * theplayer go to right
		 **/
		public void moveRight(IPosition position, IMap map) {
			int x = position.getX();
			int y = position.getY();
			if (map.getChar(x++,y) =='X' || map.getChar(x++, y) =='O' || map.getChar(x++, y) =='D' || map.getChar(x++, y) =='S' && Exit.getOpen() == true ) {
				map.setChar(x++, y,'P');
				map.setChar(x, y , 'X');
				position.setY(x++);
			}
			else if(map.getChar(x++, y) =='R' && map.getChar(x+2, x) == 'X') {
				map.setChar(x--, x, 'P');
				map.setChar(x+2, x, 'R');
			}
		}

}
