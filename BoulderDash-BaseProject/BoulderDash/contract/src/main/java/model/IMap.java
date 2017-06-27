package model;

public interface IMap {

	public char getChar(int x,int y);
	public void setChar(int x,int y,char c);
	public char[][] getMap();
	public void setMap(char[][] tab);
	public void decrypt();
}
