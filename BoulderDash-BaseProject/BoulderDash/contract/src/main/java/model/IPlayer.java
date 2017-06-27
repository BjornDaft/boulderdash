package model;

import java.io.IOException;

public interface IPlayer {
	public void buildImage(final int imagePositionX,final int imagePositionY) throws IOException;
	public boolean getIsAlive();
	public void setIsAlive(boolean alive);
	public String getDirection();
	public void setDirection(String direction);
}
