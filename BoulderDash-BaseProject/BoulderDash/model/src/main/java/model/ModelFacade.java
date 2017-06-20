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
	
	private Ground ground;
	private final ArrayList<IMobile> mobiles;

	/**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
    	this.mobiles = new ArrayList<>();
    }

	public void buildArea(Dimension dimension) {
		// TODO Auto-generated method stub
		this.ground = new Ground(dimension);
	}

	@Override
	public IArea getArea() {
		// TODO Auto-generated method stub
		return this.ground;
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
	public void setMobilesHavesMoved() {
		// TODO Auto-generated method stub
		
	}



 

}
