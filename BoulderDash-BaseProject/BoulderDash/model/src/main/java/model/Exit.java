package model;

public class Exit {

	private static String IMAGE="Exit";
	private boolean open=false;
	private int posX;
	private int posY;
	public Exit(Position position){
		this.posX = position.getX();
		this.posY = position.getY();
	}
}
