package model;

public class Element {
	protected IPosition position;
	protected IMap map;
	protected IGravity gravity;
	protected int x;
	protected int y;

	public Element(final IPosition position, final int imagePositionX, final int imagePositionY) {

		this.position = position;
		this.x = position.getX();
		this.y = position.getY();
	}
	public Element(final IPosition position, char type){
		this.position = position;
	}

	public IPosition getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	public void gravity(IPosition position, IMap map) {
		this.gravity = new NoGravity();

	}
}
