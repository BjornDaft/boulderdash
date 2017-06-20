package controller;

import java.sql.SQLException;
import java.util.List;

import controllercontract.IController;
import modelcontract.Example;
import modelcontract.IModel;
import viewcontract.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The viewcontract. */
    private final IView  view;

    /** The modelcontract. */
    private final IModel model;

    /**
     * Instantiates a new controllercontract facade.
     *
     * @param viewcontract
     *            the viewcontract
     * @param modelcontract
     *            the modelcontract
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        // a.append(" bar);
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
    }

    /**
     * Gets the viewcontract.
     *
     * @return the viewcontract
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the modelcontract.
     *
     * @return the modelcontract
     */
    public IModel getModel() {
        return this.model;
    }

	
	public void orderPerform(UserOrder userOrder) {
		// TODO Auto-generated method stub
		
	}
	public void setViewSystem(IView viewSystem){
		
	}
}
