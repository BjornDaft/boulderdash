package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Element {
	private static int IMAGEPOSITIONXUP = 2;
	private static int IMAGEPOSITIONYUP = 2;
	private static int IMAGEPOSITIONXDOWN = 4;
	private static int IMAGEPOSITIONYDOWN = 5;
	private static int IMAGEPOSITIONXRIGHT = 2;
	private static int IMAGEPOSITIONYRIGHT = 3;
	private static int IMAGEPOSITIONXLEFT = 2;
	private static int IMAGEPOSITIONYLEFT = 1;
	private static String direction;
	private static boolean isAlive;

	int x = position.getX();
	int y = position.getY();

	public Player(Position position, final String string) {
		super(position, IMAGEPOSITIONXUP, IMAGEPOSITIONYUP);
		this.setDirection(string);
		this.position = position;
		this.gravity();
		this.move();
	}

	@Override
	public void buildImage(final int imagePositionX, final int imagePositionY) throws IOException {

		File f = new File(".");
		System.out.println(f.getCanonicalPath() + "/");

		BufferedImage imageSource = ImageIO.read(new File(f.getCanonicalPath() + "/Image/BoulderDash.png"));

		switch (Player.getDirection()) {
		case "UP":
			this.image = (imageSource).getSubimage(IMAGEPOSITIONXUP * 16, IMAGEPOSITIONYUP * 16, 16, 16);
			break;
		case "RIGHT":
			this.image = (imageSource).getSubimage(IMAGEPOSITIONXDOWN * 16, IMAGEPOSITIONYDOWN * 16, 16, 16);
			break;
		case "DOWN":
			this.image = (imageSource).getSubimage(IMAGEPOSITIONXRIGHT * 16, IMAGEPOSITIONYRIGHT * 16, 16, 16);
			break;
		case "LEFT":
			this.image = (imageSource).getSubimage(IMAGEPOSITIONXLEFT * 16, IMAGEPOSITIONYLEFT * 16, 16, 16);
			break;
		default:
			break;
		}
	}
	public void gravity() {
		this.gravity = new NoGravity();
	}
	public void move() {
		this.move = new MovePlayer();
	}
	public static boolean getIsAlive() {
		return isAlive;
	}
	public static void setIsAlive(boolean alive) {
		isAlive = alive;
	}

	public static String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		Player.direction = direction;
	}
}