package view;

import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import controller.IOrderPerformer;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Group 4
 * @version 1.0
 */
public class ViewFacade implements IViewFacade{

	private GameFrame gameFrame;
	/**
	 * Instantiates a new view facade.
	 * 
	 * 
	 */
	public ViewFacade(final IOrderPerformer orderPerformer) {
		super();
		gameFrame = new GameFrame(new EventPerformer(orderPerformer));

	}
	
	
	@Override
    public void drawImage(BufferedImage image, int x, int y) {
        gameFrame.getGamePanel().setImage(image, x, y);

	}
	/*
	 * Instantiates a object JFrame
	 */

	
	/**
	 * Display a pop up
	 */
	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	/**
	 * Close the JFrame 
	 */


}
