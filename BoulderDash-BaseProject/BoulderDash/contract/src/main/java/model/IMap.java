package model;

import java.io.IOException;
import java.sql.SQLException;

public interface IMap {

	public char getChar(int x,int y);
	public void setChar(int x,int y,char c);
	public char[][] getTab();
	public void getMap(int idLvl) throws SQLException, IOException;
	public void setTab(char[][] tab);
	public void decrypt();
	public void generatelvl();
	public void updatelvl(char[][] tab);
}
