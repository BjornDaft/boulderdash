package model;

import java.io.IOException;

public class Player extends Element implements IPlayer {
	private static int IMAGEPOSITIONXUP = 2;
	private static int IMAGEPOSITIONYUP = 2;
	private String direction;
	private boolean isAlive;
	@SuppressWarnings("unused")
	private IMovePlayer move;

	int x = position.getX();
	int y = position.getY();

	public Player(Position position, final String string) {
		super(position, IMAGEPOSITIONXUP, IMAGEPOSITIONYUP);
		this.gravity();
		this.move();
	}

	public void gravity() {
		this.gravity = new NoGravity();
	}
	public void move() {
		this.move = new MovePlayer();
	}
	public boolean getIsAlive() {
		return this.isAlive;
	}
	public void setIsAlive(boolean alive) {
		this.isAlive = alive;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public void buildImage(int imagePositionX, int imagePositionY) throws IOException {
		// TODO Auto-generated method stub
		
	}

}