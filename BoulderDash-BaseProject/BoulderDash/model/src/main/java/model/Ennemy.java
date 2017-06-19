package model;

public class Ennemy {

	private int posX;
	private int posY;
	private boolean giveReward;
	public Ennemy(Position position, Direction direction,boolean giveReward){
		this.posX = position.getX();
		this.posY = position.getY();
		this.giveReward = giveReward;

	}
}
