package model;

public interface IExit {
	public boolean getOpen();
	public void state(IMap map1);
	public void win (IPosition position, IMap map);
	public int getCollectedDiamond();
	public void setCollectedDiamond();
	public void setWin (boolean winner);
	public boolean getWin();
}
