package model;

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
		public void moveUp(Position position, Array array) {
			int x = position.getX();
			int y = position.getY();
			if (array.getType(x,y --) =="Empty" || array.getType(x, y--) =="Mud") {
			array.setType(x, y --,'P');
			array.setType(x, y --, 'X');
			position.setY(y--);
			}
		}
		public void moveDown(Position position, Array array) {
			int x = position.getX();
			int y = position.getY();
			if (array.getType(x,y ++) =="Empty" || array.getType(x, y++) =="Mud") {
			array.setType(x, y ++,'P');
			array.setType(x, y ++, 'X');
			position.setY(y--);
			}
		}
		public void moveLeft(Position position, Array array) {
			int x = position.getX();
			int y = position.getY();
			if (array.getType(x--,y) =="Empty" || array.getType(x--, y) =="Mud") {
			array.setType(x--, y,'P');
			array.setType(x--, y, 'X');
			position.setY(x--);
			}
		}
		public void moveRight(Position position, Array array) {
			int x = position.getX();
			int y = position.getY();
			if (array.getType(x,y ++) =="Empty" || array.getType(x, y++) =="Mud") {
			array.setType(x, y ++,'P');
			array.setType(x, y ++, 'X');
			position.setY(y++);
			}
		}

}
