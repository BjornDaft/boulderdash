package view;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import model.IMobile;
import model.IModelFacade;

public class GraphicsBuilder implements IGraphicsBuilder {
	private final IModelFacade model;

	public GraphicsBuilder(IModelFacade model) {
		this.model = model;
	}

	@Override
	public void applyModelToGraphic(Graphics graphics, ImageObserver observer) {
		for (final IMobile mobile : this.model.getMobiles()) {
			this.drawMobile(mobile, graphics, observer);
		}
	}

	public int getGlobalWidth() {
		return this.model.getArea().getWidth();

	}

	public int getGlobalHeight() {
		return this.model.getArea().getWidth();

	}

	private void drawMobile(IMobile mobile, Graphics graphics, ImageObserver observer) {

	}
}
