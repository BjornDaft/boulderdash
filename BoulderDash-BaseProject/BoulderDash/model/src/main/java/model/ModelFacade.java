package model;

import java.util.ArrayList;
import java.util.Observable;


/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade extends Observable implements IModelFacade {
	
	

	/**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
    	this.mobiles = new ArrayList<>();
    }


	public void addMobile(IMobile mobile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMobile(IMobile mobile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<IMobile> getMobiles() {
		// TODO Auto-generated method stub
		return this.mobiles;
	}


	@Override
	public Object[][] getTab() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setType(int i, int j, char c) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getType(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getElement() {
		// TODO Auto-generated method stub
		return null;
	}

}
