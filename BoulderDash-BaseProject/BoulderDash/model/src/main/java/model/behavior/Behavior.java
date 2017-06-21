package model.behavior;

import model.*;

public abstract class Behavior implements IBehavior{
	protected int posX, posY;
	@Override
	public abstract void behavior(Position position, Array array);
}
