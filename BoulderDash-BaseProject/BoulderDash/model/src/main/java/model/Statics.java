package model;

import java.awt.Image;
import java.awt.Point;

public class Statics implements IStatics{
	private int HEIGHT = 16;
	private int WIDTH = 16;
	protected Behavior behavior;
	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Dimension getDimention() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void placeInArea() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelFacade getModel(){
		return null;
		
	}
	
	public void setModel(IModelFacade model){
		
	}
	public Behavior behavior(){
		return behavior;
	}
}
