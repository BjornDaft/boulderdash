package model;

public class Enemy extends Element implements IMove {

	private static int IMAGEPOSITIONX = 16;
	private static int IMAGEPOSITIONY = 1;
	int x = position.getX();
	int y = position.getY();

	public Enemy(Position position, Array array) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.position = position;
	}

	public void move(Array array) {

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

	public void giveDiamond(Array array) {
		if (array.getType(x, y--) == "Player" || array.getType(x, y++) == "Player" || array.getType(x++, y) == "Player"
				|| array.getType(x--, y) == "Player" || array.getType(x, y--) == "Rock") {
			for (x--; x == x++; x++) {
				for (y--; x == x++; x++) {
					if (array.getType(x, y) == "Player") {
						// death case
					}

					array.setType(x, y, 'D');
				}
			}
		}
	}

	public void kill(Array array) {
		if (array.getType(x, y--) == "Player" || array.getType(x, y++) == "Player" || array.getType(x++, y) == "Player"
				|| array.getType(x--, y) == "Player" || array.getType(x, y--) == "Rock") {
			for (x--; x == x++; x++) {
				for (y--; x == x++; x++) {
					if (array.getType(x, y) == "Player") {
						// death case
					}

					array.setType(x, y, 'X');
				}
			}
		}
	}

	@Override
	public void gravity(Position position, Array array) {

	}
}
