package controller;

import java.io.IOException;
import java.sql.SQLException;

import model.IMap;
import model.IModelFacade;
import view.IViewFacade;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @author Group 4
 * @version 1.0
 */
public class ControllerFacade implements IControllerFacade {
	private static final long TIME_SLEEP = 500;
	private IMap map;
	private OrderController orderController;
	/** The view. */
	private final IViewFacade view;

	/** The model. */
	private IModelFacade model;

	/**
	 * Boolean which indicates if game is over
	 */
	private boolean isGameOver = false;

	/**
	 * Instantiates a new controller facade.
	 * @param model
	 *            the model
	 */	
	public ControllerFacade(IModelFacade model,IViewFacade view) {
		// super();

		this.model = model;
		this.map = model.getMap();
		this.view = view;
		

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
		//this.view.closeAll();

	}
	public void test() throws SQLException,InterruptedException,IOException{
		this.map.generatelvl();
		this.map.getMap(2);
		this.map.decrypt();
		char[][] mapFirst = this.map.getTab();
		for (int i=0;i<mapFirst.length;i++){
			for (int j=0;j<mapFirst[0].length;j++){
				System.out.print(mapFirst[i][j]);
			}
			System.out.println();
		}
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

	/**
	 * Game infinite loop while it isn't over
	 */
	private void gameLoop() {
		while (!this.isGameOver) {
			try {
				Thread.sleep(TIME_SLEEP);
				if (model.isGameOver() == true) {
					this.isGameOver = true;
				}

			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
		//
	}

	
	public IMap getMap() {
		// TODO Auto-generated method stub
		return map;
	}

	public void orderPerform(IUserOrder userOrder) {
		// TODO Auto-generated method stub

	}

	public OrderController getOrderController() {
		if (orderController == null)
			orderController = new OrderController();
		return orderController;
	}

}