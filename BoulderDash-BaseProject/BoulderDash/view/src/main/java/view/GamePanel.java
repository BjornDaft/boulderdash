package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Observer {
	private static final long serialVersionUID = 3987064896591403626L;
	private final IGraphicsBuilder graphicsBuilder;

	
	public GamePanel(IGraphicsBuilder graphicBuilder) {
		this.graphicsBuilder = graphicBuilder;
	}

	@Override
	public void paintComponent(Graphics graphics) {
		this.graphicsBuilder.applyModelToGraphic(graphics, this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		this.repaint();
	}
}
