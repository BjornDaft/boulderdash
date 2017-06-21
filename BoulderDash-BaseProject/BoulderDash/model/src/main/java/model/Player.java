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

	public Player(Position position, final int imagePositionXUP, final int imagePositionYUP, final int imagePositionXDOWN, final int imagePositionYDOWN, final int imagePositionXRIGHT, final int imagePositionYRIGHT, final int imagePositionXLEFT, final int imagePositionYLEFT, Direction direction) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY,IMAGEPOSITIONXDOWN,IMAGEPOSITIONYDOWN,IMAGEPOSITIONXRIGHT,IMAGEPOSITIONYRIGHT,IMAGEPOSITIONXLEFT,IMAGEPOSITIONYLEFT);

	}

	@Override
	private void buildImage(final int imagePositionX, final int imagePositionY) throws IOException {

		File f = new File(".");
		System.out.println(f.getCanonicalPath() + "/");

		BufferedImage imageSource = ImageIO.read(new File(f.getCanonicalPath() + "/Image/BoulderDash.png"));
		this.image = (imageSource).getSubimage(imagePositionX * 16, imagePositionY * 16, 16, 16);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
