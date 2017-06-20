package model;

public class Exit extends Statics{

	private static String IMAGE="Exit";
	private boolean open=false;
	private int posX;
	private int posY;
	public Exit(Position position){
		this.posX = position.getX();
		this.posY = position.getY();
	}
	public Behavior behavior() {
		return this.behavior = new BehaviorExit();
	}
}
