package view;

/**
 * <h1>The Interface IViewFacade.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IViewFacade {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */

    public void displayMessage(String message);
	public void closeAll();
}
