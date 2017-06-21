package model;

import java.awt.Image;
import model.behavior.*;

public interface IStatics {
	public Position getPosition();

	public void placeInArea();

	public Image getImage();
	
	public Behavior behavior();

	public void setModel(IModelFacade model);

	void placeInArea(IArea area);
}
