package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.ControllerFacade;
import model.ModelFacade;
import model.dao.MapDAO;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException 
     * @throws InterruptedException 
     */
	public static void main(final String[] args) throws InterruptedException, IOException{
    	MapDAO map = new MapDAO();
    	ModelFacade model = new ModelFacade(map);
    	ViewFacade view = new ViewFacade(null);
        ControllerFacade controller = new ControllerFacade(model,view);
        try {
            controller.test();
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }
}
