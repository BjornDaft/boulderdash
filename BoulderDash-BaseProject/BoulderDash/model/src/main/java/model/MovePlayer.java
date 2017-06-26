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
	public void move(Position position, Array array, Direction direction) {
			switch (direction) {
				case UP:
					this.moveUp(position, array);
				break;
				case DOWN:
					this.moveDown(position, array);
				break;
				case LEFT:
					this.moveLeft(position, array);
				break;
				case RIGHT:
					this.moveRight(position, array);
				break;
			}
		}
	/**
	 * the player is go to up
 **/
		public void moveUp(Position position, Array array) {
			int x = position.getX();
			int y = position.getY();
			if (array.getType(x,y --) =="Empty" || array.getType(x, y++) =="Mud" || array.getType(x, y--) =="Diamond" || array.getType(x, y--) =="Exit" && Exit.getOpen() == true) {
			array.setType(x, y --,'P');
			array.setType(x, y, 'X');
			position.setY(y--);
			}
		}
		/**
		 * player go to down
		 **/
		public void moveDown(Position position, Array array) {
			int x = position.getX();
			int y = position.getY();
			if (array.getType(x,y ++) =="Empty" || array.getType(x, y++) =="Mud"|| array.getType(x, y++) =="Diamond" || array.getType(x, y--) =="Exit" && Exit.getOpen() == true) {
			array.setType(x, y ++,'P');
			array.setType(x, y , 'X');
			position.setY(y++);
			}
			
		}
		/**
		 * the player go to left 
	 **/
		public void moveLeft(Position position, Array array) {
			int x = position.getX();
			int y = position.getY();
			if (array.getType(x--,y) =="Empty" || array.getType(x--, y) =="Mud" || array.getType(x--, y) =="Diamond" || array.getType(x--, y) =="Exit" && Exit.getOpen() == true) {
			array.setType(x--, y,'P');
			array.setType(x, y, 'X');
			position.setY(x--);
			}
			else if(array.getType(x--, y) =="Rock" && array.getType(x-2, x) == "Empty") {
				array.setType(x--, x, 'P');
				array.setType(x-2, x, 'R');
			}
		}
		/**
		 * theplayer go to right
		 **/
		public void moveRight(Position position, Array array) {
			int x = position.getX();
			int y = position.getY();
			if (array.getType(x++,y) =="Empty" || array.getType(x++, y) =="Mud" || array.getType(x++, y) =="Diamond" || array.getType(x++, y) =="Exit" && Exit.getOpen() == true ) {
				array.setType(x++, y,'P');
				array.setType(x, y , 'X');
				position.setY(x++);
			}
			else if(array.getType(x++, y) =="Rock" && array.getType(x+2, x) == "Empty") {
				array.setType(x--, x, 'P');
				array.setType(x+2, x, 'R');
			}
		}

}
