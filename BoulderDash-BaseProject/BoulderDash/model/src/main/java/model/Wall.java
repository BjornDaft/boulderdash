package model;

public class Wall extends Statics {
	private static String IMAGE = "Wall";
	public boolean isBorderMap(){
		return true;
	}
	private int posX;
	private int posY;
	public Wall(Position position){
	this.posX = position.getX();
	this.posY = position.getY();

	}
}
