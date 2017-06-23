package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Element implements IMove {
	private static int IMAGEPOSITIONXUP = 2;
	private static int IMAGEPOSITIONYUP = 2;
	private static int IMAGEPOSITIONXDOWN = 4;
	private static int IMAGEPOSITIONYDOWN = 5;
	private static int IMAGEPOSITIONXRIGHT = 2;
	private static int IMAGEPOSITIONYRIGHT = 3;
	private static int IMAGEPOSITIONXLEFT = 2;
	private static int IMAGEPOSITIONYLEFT = 1;
	private Direction direction;

	int x = position.getX();
	int y = position.getY();

	public Player(Position position, final Direction direction) {
		super(position, IMAGEPOSITIONXUP, IMAGEPOSITIONYUP);
		this.direction = direction;
		this.position = position;
	}

	@Override
	public void buildImage(final int imagePositionX, final int imagePositionY) throws IOException {

		File f = new File(".");
		System.out.println(f.getCanonicalPath() + "/");

		BufferedImage imageSource = ImageIO.read(new File(f.getCanonicalPath() + "/Image/BoulderDash.png"));

		switch (this.direction) {
		case UP:
			this.image = (imageSource).getSubimage(IMAGEPOSITIONXUP * 16, IMAGEPOSITIONYUP * 16, 16, 16);
			break;
		case RIGHT:
			this.image = (imageSource).getSubimage(IMAGEPOSITIONXDOWN * 16, IMAGEPOSITIONYDOWN * 16, 16, 16);
			break;
		case DOWN:
			this.image = (imageSource).getSubimage(IMAGEPOSITIONXRIGHT * 16, IMAGEPOSITIONYRIGHT * 16, 16, 16);
			break;
		case LEFT:
			this.image = (imageSource).getSubimage(IMAGEPOSITIONXLEFT * 16, IMAGEPOSITIONYLEFT * 16, 16, 16);
			break;
		default:
			break;
		}
	}
	
	public void move() {
		switch (this.direction) {
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
		if (array.getType(x,y --) =="Empty" || array.getType(x, y--) =="Mud") {
		array.setType(x, y --,'P');
		}
	}
	public void moveDown(Position position, Array array) {
		if (array.getType(x,y ++) =="Empty" || array.getType(x, y++) =="Mud") {
		array.setType(x, y ++,'P');
		}
	}
	public void moveLeft(Position position, Array array) {
		if (array.getType(x--,y) =="Empty" || array.getType(x--, y) =="Mud") {
		array.setType(x--, y,'P');
		}
	}
	public void moveRight(Position position, Array array) {
		if (array.getType(x,y ++) =="Empty" || array.getType(x, y++) =="Mud") {
		array.setType(x, y ++,'P');
		}
	}
	public void gravity(Position position, Array array) {
			this.gravity = new NoGravity();
	}
}