package model;





public class Ground implements IArea{
	private final Dimension	dimension;
	
	public Ground(Dimension dimension) {
		// TODO Auto-generated constructor stub
		this.dimension = dimension;
	}

	@Override
	public Dimension getDimension() {
		// TODO Auto-generated method stub
		return this.dimension;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.getDimension().getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.getDimension().getHeight();
	}



}