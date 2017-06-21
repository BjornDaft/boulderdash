package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import model.behavior.Behavior;
import javax.imageio.ImageIO;

public class Mobile implements IMobile {
	protected Behavior behavior;
<<<<<<< HEAD
	private Direction direction;
	private Position position;
=======
	protected Position position;
	protected Direction direction;
	protected Array array;
>>>>>>> branch 'master' of https://github.com/BjornDaft/boulderdash
	private Image images[];
	private IModelFacade model;

	public Mobile(final Direction direction, final Position position, final String image, Behavior behavior) {
		this.direction = direction;
		this.position = position;

		try {
			this.buildAllimages(image);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return this.direction;
	}

	@Override
	public void setDirection(Direction direction) {
		// TODO Auto-generated method stub
		this.direction = direction;
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return this.images[this.direction.ordinal()];
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		switch (this.direction) {
		case UP:
			this.moveUp();
			break;
		case RIGHT:
			this.moveRight();
			break;
		case DOWN:
			this.moveDown();
			break;
		case LEFT:
			this.moveLeft();
			break;
		default:
			break;
		}
	}

	// � corriger
	private void moveUp() {
		this.position.setY(this.position.getY() - 1);
	}

	private void moveRight() {
		this.position.setX(this.position.getX() + 1);
	}

	private void moveDown() {
		this.position.setY(this.position.getY() + 1);
	}

	private void moveLeft() {
		this.position.setX(this.position.getX() - 1);
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

	private void buildAllimages(final int Up) throws IOException {
		this.images = new Image[4];

		File f = new File(".");
		System.out.println(f.getCanonicalPath() + "/");

		this.images[Direction.UP.ordinal()] = ImageIO
				.read(new File(f.getCanonicalPath() + "/Image/BoulderDash.png"));
		this.images[Direction.RIGHT.ordinal()] = ImageIO
				.read(new File(f.getCanonicalPath() + "/Image/BoulderDash.png"));
		this.images[Direction.DOWN.ordinal()] = ImageIO
				.read(new File(f.getCanonicalPath() + "/Image/BoulderDash.png"));
		this.images[Direction.LEFT.ordinal()] = ImageIO
				.read(new File(f.getCanonicalPath() + "/Image/BoulderDash.png"));
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



}



