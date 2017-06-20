package model;

import java.util.ArrayList;

/**
 * <h1>The Interface IModelFacade.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModelFacade {
	public void buildArea(final Dimension dimension);

	public IArea getArea();

	public void addMobile(final IMobile mobile);

	public void removeMobile(final IMobile mobile);

	public ArrayList<IMobile> getMobiles();

	public void setMobilesHavesMoved();
}
/**
 * Gets the example by id.
 *
 * @param id
 *            the id
 * @return the example by id
 * @throws SQLException
 *             the SQL exception
 *
 *             Example getExampleById(int id) throws SQLException;
 * 
 *             /** Gets the example by name.
 *
 * @param name
 *            the name
 * @return the example by name
 * @throws SQLException
 *             the SQL exception
 *
 *             Example getExampleByName(String name) throws SQLException;
 * 
 *             /** Gets the all examples.
 *
 * @return the all examples
 * @throws SQLException
 *             the SQL exception
 *
 *             List<Example> getAllExamples() throws SQLException;
 */
