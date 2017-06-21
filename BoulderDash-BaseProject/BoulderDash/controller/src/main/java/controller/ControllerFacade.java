package controller;

import java.io.IOException;
import java.sql.SQLException;

import model.IModelFacade;
import view.IViewFacade;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IControllerFacade {

	/** The view. */
	private final IViewFacade view;

	/** The model. */
	private final IModelFacade model;

	/**
	 * Instantiates a new controller facade.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	private boolean isGameOver = false;
	private static int TIME_SLEEP = 50;

	public ControllerFacade(final IViewFacade view, final IModelFacade model) {
		// super();
		this.view = view;
		this.model = model;
	}

	/**
	 * Start.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void start() throws SQLException {
		this.gameLoop();
		this.view.displayMessage("Game Over!");
		this.view.closeAll();

	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public IViewFacade getView() {
		return this.view;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public IModelFacade getModel() {
		return this.model;
	}

	public void setViewFacade(IViewFacade view) {

	}

	private void gameLoop() {
		while (!this.isGameOver) {
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
		//
	}

	@Override
	public void orderPerform(UserOrder userOrder) {
		if (userOrder != null) {
			final IMobile plane = this.model.getMobilePlayer(userOrder);
			if (player != null) {
				Direction direction;
				switch (userOrder.getOrder()) {
				case UP:
					direction = Direction.UP;
					break;
				case RIGHT:
					direction = Direction.RIGHT;
					break;
				case DOWN:
					direction = Direction.DOWN;
					break;
				case LEFT:
					direction = Direction.LEFT;
					break;
				/*
				 * case PUSH: try { this. }
				 */
				
				
				default:
					//
					break;
			}
				player.setDirection(direction);
		}
	}

}
}