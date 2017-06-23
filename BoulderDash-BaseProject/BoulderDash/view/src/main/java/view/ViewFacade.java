package view;

import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.IModelFacade;
import model.IOrderPerformer;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Group 4
 * @version 1.0
 */
public class ViewFacade implements IViewFacade, Runnable {

	private final GraphicsBuilder graphicsBuilder;
	private final EventPerformer eventPerformer;
	private final Observable observable;
	private GameFrame gameFrame;

	
	
	/**
	 * Instantiates a new view facade.
	 * 
	 * 
	 */
	public ViewFacade(final IOrderPerformer orderPerformer, final IModelFacade model) {
		this.observable = (Observable) model;
		this.graphicsBuilder = new GraphicsBuilder(model);
		this.eventPerformer = new EventPerformer(orderPerformer);
		
		SwingUtilities.invokeLater(this);
	}
	
	
	
	/*
	 * Instantiates a object JFrame
	 */

	public void run() {
		this.gameFrame = new GameFrame("Boulder Dash", this.eventPerformer, this.graphicsBuilder, this.observable);
	}
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
	@Override
	public void closeAll() {
		// TODO Auto-generated method stub
		this.gameFrame.dispose();
	}

}
