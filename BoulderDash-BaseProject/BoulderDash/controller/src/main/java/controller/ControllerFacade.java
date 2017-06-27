package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import model.IGravity;
import model.IMap;
import model.IModelFacade;
import model.IMove;
import model.IPlayer;
import model.IPosition;
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

	private IPosition position;
	private IGravity gravity;
	private IMove move;
	boolean key_right, key_left, key_down, key_up;

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
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public void start() throws SQLException, InterruptedException, IOException {
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
				this.position.setX(i);
				this.position.setY(j);
				
				
				System.out.print(mapFirst[i][j]);
			}
			System.out.println();
		}
		this.map.setTab(mapFirst);
		this.map.updatelvl(mapFirst);
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
	private void gameLoop() throws SQLException,InterruptedException,IOException{
		while (!this.isGameOver) {
			try {
				this.map.decrypt();
				char[][] mapFirst = this.map.getTab();
				for (int i=0;i<mapFirst.length;i++){
					for (int j=0;j<mapFirst[0].length;j++){
						System.out.print(mapFirst[i][j]);
						this.position.setX(i);
						this.position.setY(j);
						this.gravity.gravity(this.position, this.map);
						//java.awt.Component.addKeyListener(new GameInput());
						//this.movePlayer.move(this.position, this.map, null);
					}
					System.out.println();
				}
				this.map.setTab(mapFirst);
				this.map.updatelvl(mapFirst);
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
	private class GameInput implements KeyListener {
        public void keyTyped(KeyEvent e) {}

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == e.VK_DOWN) key_down = false;
            if (e.getKeyCode() == e.VK_UP) key_up = false;
            if (e.getKeyCode() == e.VK_RIGHT) key_right = false;
            if (e.getKeyCode() == e.VK_LEFT) key_left = false;
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == e.VK_DOWN) key_down = true;
            if (e.getKeyCode() == e.VK_UP) key_up = true;
            if (e.getKeyCode() == e.VK_RIGHT) key_right = true;
            if (e.getKeyCode() == e.VK_LEFT) key_left = true;
        }
	}
}