package model;

import java.awt.Image;
import model.behavior.*;

public interface IMobile {
	public Direction getDirection();

	public void setDirection(final Direction direction);

	public Position getPosition();

	public Image getImage();

	public void move();

	public void placeInArea(IArea area);

	public void setModel(IModelFacade model);
	
	public int getWidth();

	public int getHeight();
	
	public Behavior behavior(Position position, Array array);
}
