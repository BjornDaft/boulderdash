package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import model.IModelFacade;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements IViewFacade {
	private BufferedImage image;
	private int xpos;
	private int ypos;


	public GamePanel(IModelFacade model) {
		image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, xpos, ypos, null);
	}


	

	public int getXpos() {
		return xpos;
	}

	public int getYpos() {
		return ypos;
	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawImage(BufferedImage image, int x, int y) {
		// TODO Auto-generated method stub
		
	}


	    public void setImage(BufferedImage image, int x, int y) {
	        this.image = image;
	        this.xpos = x;
	        this.ypos = y;
	        repaint();
	    }
	
}
