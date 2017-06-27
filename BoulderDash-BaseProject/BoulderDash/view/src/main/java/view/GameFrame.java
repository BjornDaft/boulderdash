package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

import controller.IEventPerformer;
import model.IModelFacade;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements KeyListener {
	
	private final IEventPerformer eventPerformer;
	private GamePanel gamePanel;
	/**
	 * instantiate GameFrame to create a JFrame with the panel
	 * 
	 * @param eventPerformer
	 * @param observable
	 */
	public GameFrame(final IEventPerformer eventPerformer, final IModelFacade model) {
		super();
		this.eventPerformer = eventPerformer;
		this.addKeyListener(this);
		this.setTitle("Boulder Dash");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		gamePanel = new GamePanel(model);
		this.addKeyListener(this);
		this.setSize(600,700);	
		this.setLocation(100, 100);
		this.setContentPane(gamePanel);

		this.setVisible(true);
	}

	/**
	 * get KeyListener result
	 * 
	 * @param keyEvent
	 */
	@Override
	public void keyPressed(final KeyEvent keyEvent) {

			this.eventPerformer.eventPerform(keyEvent);

	}

	@Override
	public void keyReleased(final KeyEvent keyEvent) {

	}

	@Override
	public void keyTyped(final KeyEvent keyEvent) {

	}
	  public GamePanel getGamePanel() {
	        return gamePanel;
	    }

}
