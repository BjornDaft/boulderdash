package model;

import java.awt.image.BufferedImage;
import java.util.List;

public interface IElement {
	public IPosition getPosition();
	public BufferedImage getImage();
	public IModelFacade getModelFacade() ;
	}
