package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Element {
	protected Position position;
	protected Array array;
	protected IGravity gravity;

	private IModelFacade model;
	protected BufferedImage image;

	public Element(final Position position, final 
int imagePositionX, final int imagePositionY) {

		this.position = position;

		try {
			
this.buildImage(imagePositionX, imagePositionY);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public Position getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}


	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return this.image;
	}

	public IModelFacade getModelFacade() {
		return this.model;
	}

	public void buildImage(final int 
imagePositionX, final int imagePositionY) throws 
IOException {

		File f = new File(".");
		
System.out.println(f.getCanonicalPath() + "/");

		BufferedImage imageSource = 
ImageIO.read(new File(f.getCanonicalPath() + 
"/Image/BoulderDash.png"));
		this.image = 
(imageSource).getSubimage(imagePositionX * 16, 
imagePositionY * 16, 16, 16);
	}

	public void gravity(Position position, Array array) {
			this.gravity = new NoGravity();
		
	}
}
