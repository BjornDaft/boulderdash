package model;

import model.dao.Map;



public class Exit extends Element {
	private static int IMAGEPOSITIONX = 13;
	private static int IMAGEPOSITIONY = 1;
	private static boolean open = false;
	
	public Exit(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
	}
	public void state(Map map1) {
		if (map1.getNbdiamond() == Player.collectDiamond()) {
			open = true;
			}
		}
	public void win(Position position, Array array) {
		if (array.getType(this.position.getX(), this.position.getY()) == "Player" && open == true) {
			System.exit(0);
		}
	}
}
