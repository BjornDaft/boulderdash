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
	private IExit exit;
	private ICollectedDiamond collectedDiamond;
	private IDig dig;
	private IPush push;
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
			switch (map.getChar(x, y--)) {
			case 'X':
				break;
			case 'O' :
				this.dig.setDig(true);
				break;
			case 'D' :
				this.collectedDiamond.setCollectDiamond();;
				break;
			case 'S' :
				if (this.exit.getOpen() == true) {
					this.exit.setWin(true);
				} else {
					return;
				}
				break;
			}
			map.setChar(x, y --,'P');
			map.setChar(x, y, 'X');
			position.setY(y--);
		}
		/**
		 * player go to down
		 **/
		public void moveDown(IPosition position, IMap map) {
			int x = position.getX();
			int y = position.getY();
			switch (map.getChar(x, y++)) {
			case 'X':
				break;
			case 'O' :
				this.dig.setDig(true);
				break;
			case 'D' :
				this.collectedDiamond.setCollectDiamond();;
				break;
			case 'S' :
				if (this.exit.getOpen() == true) {
					this.exit.setWin(true);
				} else {
					return;
				}
				break;
			}
			map.setChar(x, y++,'P');
			map.setChar(x, y, 'X');
			position.setY(y++);
			
		}
		/**
		 * the player go to left 
	 **/
		public void moveLeft(IPosition position, IMap map) {
			int x = position.getX();
			int y = position.getY();
			switch (map.getChar(x++, y)) {
			case 'X':
				break;
			case 'O' :
				this.dig.setDig(true);
				break;
			case 'D' :
				this.collectedDiamond.setCollectDiamond();;
				break;
			case 'S' :
				if (this.exit.getOpen() == true) {
					this.exit.setWin(true);
				} else {
					return;
				}
			case 'R' :
				this.push.push(position, map);
				break;
			}
			map.setChar(x--, y,'P');
			map.setChar(x, y, 'X');
			position.setY(x--);
		}
		/**
		 * theplayer go to right
		 * 
		 **/
		public void moveRight(IPosition position, IMap map) {
			int x = position.getX();
			int y = position.getY();
			switch (map.getChar(x--, y)) {
			case 'X':
				break;
			case 'O' :
				this.dig.setDig(true);
				break;
			case 'D' :
				this.collectedDiamond.setCollectDiamond();;
				break;
			case 'S' :
				if (this.exit.getOpen() == true) {
					this.exit.setWin(true);
				} else {
					return;
				}
			case 'R' :
				this.push.push(position, map);
				break;
			}
			map.setChar(x++,y,'P');
			map.setChar(x,y, 'X');
			position.setY(x++);
		}
		
}
