package model;

import java.awt.image.BufferedImage;

public interface IElement {
	public IPosition getPosition();
	public BufferedImage getImage();
	public IModelFacade getModelFacade() ;
	}
