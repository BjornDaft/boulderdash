package model;

import java.awt.Image;

public interface IMobile {
	public Direction getDirection();
	public void setDirection(final Direction direction);
	public Position getPosition();
	public Dimension getDimension();
	public int getWidth();
	public int getHeight();
	public int getSpeed();
	public Image getImage();
	public void move();
	public void placeInArea(IArea area);
	public void setModel(IModelFacade model);
}
