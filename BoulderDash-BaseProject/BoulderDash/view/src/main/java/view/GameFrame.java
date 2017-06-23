package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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



		this.setSize(1000,1000);
		this.setLocationRelativeTo(null);
		decrypt();
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
	public static void decrypt() {

        ObjectInputStream ois = null;

        try {
            final FileInputStream fichier = new FileInputStream("tab");
            ois = new ObjectInputStream(fichier);
            final char chartabtest[][] = (char[][]) ois.readObject();

            System.out.println("Test = " + chartabtest[0][0]);
            System.out.println("Test = " + chartabtest[0][1]);

        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
