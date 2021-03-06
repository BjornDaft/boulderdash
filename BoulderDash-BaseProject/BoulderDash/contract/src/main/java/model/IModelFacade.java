package model;

import java.util.ArrayList;

/**
 * <h1>The Interface IModelFacade.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModelFacade {
	IMap getMap();
	boolean isGameOver();  
	ArrayList<IElement> createElements();
	IPosition setPosition();
}
