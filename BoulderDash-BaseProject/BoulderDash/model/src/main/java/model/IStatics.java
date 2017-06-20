package model;

import java.awt.Image;

public interface IStatics {
	public Position getPosition();

	public int getWidth();

	public int getHeight();

	public void placeInArea();

	public Image getImage();

	public void setModel(IModelFacade model);
}
