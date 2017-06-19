package model;

public class Wall extends Statics {
	private static String IMAGE = "Wall";
	public boolean isBorderMap(){
		return true;
	}
	private int posX;
	private int posY;
	public Wall(int posX, int posY){
	this.posX = posX;
	this.posY = posY;

	}
}
