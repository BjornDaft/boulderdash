package main;

import java.sql.SQLException;

import controller.ControllerFacade;
import model.ModelFacade;
import model.dao.ExampleDAO;
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
     */
	//hello
    public static void main(final String[] args) {
        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
        System.out.println("test");
        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        
        final ExampleDAO connection = new ExampleDAO();
        try {
        	ExampleDAO.getMap(1);
        }
        catch (final SQLException exception){
        	exception.getMessage();
        	
        }
    }
}
