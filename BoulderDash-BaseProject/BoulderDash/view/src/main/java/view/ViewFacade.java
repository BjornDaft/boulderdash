package view;



import java.util.Observable;

import javax.swing.JOptionPane;

import controller.IController;
import model.IModelFacade;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade(IController orderPerformer, IModelFacade Model, Observable observable) {
       
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    
    private void run(){
    	
    }
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

	@Override
	public void closeAll() {
		// TODO Auto-generated method stub
		
	}

}
