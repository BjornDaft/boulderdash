package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;

import model.Direction;
import model.IGravity;
import model.IMap;
import model.IModelFacade;
import model.IMoveEnemy;
import model.IMoveNo;
import model.IMovePlayer;
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
	/** The view. */
	private final IViewFacade view;

	/** The model. */
	private IModelFacade model;

	private IUserOrder order;
	private final IPosition position;
	private IGravity gravity;
	private IMovePlayer movePlayer;
	private IMoveEnemy moveEnemy;
	private IMoveNo noMove;
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
		this.position = model.setPosition();

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
		//this.map.generatelvl();
		//this.map.getMap(2);
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
						//this.gravity.gravity(this.position, this.map);
						/*if (key_down) this.movePlayer.move(this.position, this.map, Direction.DOWN);
						if (key_up) this.movePlayer.move(this.position, this.map, Direction.UP);
						if (key_left) this.movePlayer.move(this.position, this.map, Direction.LEFT);
						if (key_right) this.movePlayer.move(this.position, this.map, Direction.RIGHT);*/
						this.performOrder(this.order, this.model, this.view);
						//this.moveEnemy.move(this.position, this.map, null);
						//this.noMove.move(this.position, this.map, null);
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

	public void performOrder(IUserOrder userOrder, IModelFacade model, IViewFacade view) throws IOException {
   	 switch (userOrder.getOrder()) {
   	case DOWN: 
   		this.movePlayer.move(this.position, this.map, Direction.DOWN);
   		break;
   	case UP: 
   		this.movePlayer.move(this.position, this.map, Direction.UP);
		break;
   	case LEFT:
   		this.movePlayer.move(this.position, this.map, Direction.LEFT);
		break;
   	case RIGHT:
   		this.movePlayer.move(this.position, this.map, Direction.RIGHT);
   		break;
   	 }
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