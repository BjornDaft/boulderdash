package view;

import java.awt.Graphics;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import model.IElement;
import model.IModelFacade;

public class GraphicsBuilder implements IGraphicsBuilder {
	private final IModelFacade model;

	public GraphicsBuilder(IModelFacade model) {
		this.model = model;
	}

	@Override
	public void applyModelToGraphic(Graphics graphics, ImageObserver observer) {
		for (final IElement element : this.model.getElement()) {
			this.drawElement(element, graphics, observer);
		}
	}

	private void drawElement(IElement element, Graphics graphics, ImageObserver observer) {
		final BufferedImage imageElement = new BufferedImage(16, 16,Transparency.TRANSLUCENT);
		final Graphics graphicsElement = imageElement.getGraphics();

		graphicsElement.drawImage(element.getImage(), 0, 0, 16, 16, observer);
		graphics.drawImage(imageElement,element.getPosition().getX(), element.getPosition().getY(), observer);
	}


}
