package model;

import java.awt.Image;
import java.awt.Point;

public interface IStatics {
	public Point getPosition();
	public Dimension getDimention();
	public int getWidth();
	public int getHeight();
	public void placeInArea();
	public Image getImage();
}
