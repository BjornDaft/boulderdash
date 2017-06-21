package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JFrame;





public class GameFrame extends JFrame implements KeyListener{
	private static final long serialVersionUID	= -1112124206501543946L;
	private final IEventPerformer eventPerformer;
	public GameFrame(final String title, final IEventPerformer eventPerformer, final IGraphicsBuilder graphicsBuilder, final Observable observable){
		this.eventPerformer = eventPerformer;

		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);



		this.setSize(graphicsBuilder.getGlobalWidth() + this.getInsets().left + this.getInsets().right,
				graphicsBuilder.getGlobalHeight() + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);

		final GamePanel gamePanel = new GamePanel(graphicsBuilder);
		gamePanel.setDoubleBuffered(true);
		observable.addObserver(gamePanel);

		this.setContentPane(gamePanel);

		this.setVisible(true);
	}

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
}
