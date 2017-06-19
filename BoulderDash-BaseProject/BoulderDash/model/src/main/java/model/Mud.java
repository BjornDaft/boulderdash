package model;

public class Mud {
	private static String IMAGE = "Mud";
	private int posX;
	private int posY;
	public Mud(Position position){
		this.posX = position.getX();
		this.posY = position.getY();

	}
}
