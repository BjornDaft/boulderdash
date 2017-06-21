package model.behavior;

import model.*;

public abstract class Behavior implements IBehavior{
	protected int posX, posY;
	@Override
	public abstract Behavior behavior(Position position, Array array);
}
