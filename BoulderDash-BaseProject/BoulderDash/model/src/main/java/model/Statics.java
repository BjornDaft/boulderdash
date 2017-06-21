<<<<<<< HEAD
package model;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import model.behavior.Behavior;
import javax.imageio.ImageIO;

public class Statics implements IStatics{
	
	protected Behavior behavior;
	private Position position;

	private IModelFacade model;
	private BufferedImage image;

	public Statics(final Position position, final int imagePositionX, final int imagePositionY) {
		
		this.position = position;

		try {
			this.buildImage(imagePositionX, imagePositionY);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}





	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return this.image;
	}


	@Override
	public void placeInArea(IArea area) {
		// TODO Auto-generated method stub
		this.position.setMaxX(area.getDimension().getWidth());
		this.position.setMaxY(area.getDimension().getHeight());

	}

	@Override
	public void setModel(IModelFacade model) {
		// TODO Auto-generated method stub
		this.model = model;
		this.getPosition().setMaxX(this.getModelFacade().getArea().getDimension().getWidth());
		this.getPosition().setMaxY(this.getModelFacade().getArea().getDimension().getHeight());
	}

	public IModelFacade getModelFacade() {
		return this.model;
	}

	public Behavior behavior() {
		return this.behavior;

	}

	private void buildImage(final int imagePositionX, final int imagePositionY) throws IOException {

		File f = new File(".");
		System.out.println(f.getCanonicalPath() + "/");


		BufferedImage imageSource = ImageIO.read(new File(f.getCanonicalPath() + "/Image/BoulderDash.png"));
		this.image = (imageSource).getSubimage( imagePositionX*16 , imagePositionY * 16, 16, 16);
	}





	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}





	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}





	@Override
	public void placeInArea() {
		// TODO Auto-generated method stub
		
	}
}


=======
package model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import model.behavior.*;

import javax.imageio.ImageIO;


public class Statics implements IStatics{
	
	protected Behavior behavior;
	protected Position position;
	private Image images;
	private IModelFacade model;
	protected int posX, posY;

	public Statics(final Position position, final String image) {
		
		this.position = position;

		try {
			this.buildAllimages(image);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}





	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return this.images;
	}


	@Override
	public void placeInArea(IArea area) {
		// TODO Auto-generated method stub
		this.position.setMaxX(area.getDimension().getWidth());
		this.position.setMaxY(area.getDimension().getHeight());

	}

	@Override
	public void setModel(IModelFacade model) {
		// TODO Auto-generated method stub
		this.model = model;
		this.getPosition().setMaxX(this.getModelFacade().getArea().getDimension().getWidth());
		this.getPosition().setMaxY(this.getModelFacade().getArea().getDimension().getHeight());
	}

	public IModelFacade getModelFacade() {
		return this.model;
	}

	public Behavior behavior() {
		return this.behavior;

	}

	public int getwidth() {
		
		return 0;
	}
	
	public int getHeight() {
		
		return 0;
	}
	private void buildAllimages(final String imageName) throws IOException {
		this.images = new Image;

		File f = new File(".");
		System.out.println(f.getCanonicalPath() + "/");

		this.images = ImageIO
				.read(new File(f.getCanonicalPath() + "/images/" + imageName + "_UP.png"));
		
	}
}
>>>>>>> branch 'master' of https://github.com/BjornDaft/boulderdash
