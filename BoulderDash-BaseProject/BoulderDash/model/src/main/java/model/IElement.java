package model;

import java.awt.image.BufferedImage;

public interface IElement {
	public Position getPosition();
	public BufferedImage getImage();
	public void placeInArea(IArea area);
	public void setModel(IModelFacade model);
	
}
