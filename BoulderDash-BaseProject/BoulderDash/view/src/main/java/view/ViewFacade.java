package view;

import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IControllerFacade;
import model.IModelFacade;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IViewFacade, Runnable {

	private final GraphicsBuilder graphicsBuilder;
	private final EventPerformer eventPerformer;
	private final Observable observable;
	private GameFrame gameFrame;
	private IModelFacade model;
	private Object[][] tab;
	
	
	/**
	 * Instantiates a new view facade.
	 * 
	 * 
	 */
	public ViewFacade(IControllerFacade orderPerformer, IModelFacade model, Observable observable) {
		this.observable = (Observable) model;
		this.graphicsBuilder = new GraphicsBuilder(model);
		this.eventPerformer = new EventPerformer(orderPerformer);
		this.model = model;
		this.tab = model.getTab();
		SwingUtilities.invokeLater(this);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IViewFacade#displayMessage(java.lang.String)
	 */

	public void run() {
		this.gameFrame = new GameFrame("Boulder Dash", this.eventPerformer, this.graphicsBuilder, this.observable);
	}

	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void closeAll() {
		// TODO Auto-generated method stub
		this.gameFrame.dispose();
	}

}
