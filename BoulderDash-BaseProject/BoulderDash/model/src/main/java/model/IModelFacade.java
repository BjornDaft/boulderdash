package model;

import java.util.ArrayList;

public interface IModelFacade {
	public void buildArea(final Dimension dimension);
	public IArea getArea();
	public void addMobile(final IMobile mobile);
	public void removeMobile(final IMobile mobile);
	public ArrayList<IMobile> getMobiles();
	public void setMobilesHavesMoved();

}
