package model;

public interface IPlayer {
	public void buildimage(final int imagePositionX,final int imagePositionY);
	public boolean getIsAlive();
	public void setIsAlive(boolean alive);
	public void getDirection();
	public void setDirection(String direction);
}
