package model;

import model.dao.Map;



public class Exit extends Element {
	private static int IMAGEPOSITIONX = 13;
	private static int IMAGEPOSITIONY = 1;
	private static boolean open = false;
	private static int collectedDiamond = 0;
	private static boolean win = false;
	
	public Exit(IPosition position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.win(position, map);
		Exit.state(null);
	}
	public static void state(Map map1) {
		if (map1.getNbdiamond() == getCollectedDiamond()) {
			open = true;
			}
		}
	public void win(IPosition position, IMap map) {
		if (map.getChar(this.position.getX(), this.position.getY()) == 'P' && open == true) {
			setWin(true);
		}
	}
		@Override
		public void gravity(IPosition position, IMap map) {
			this.gravity = new NoGravity();
	}
		public static int getCollectedDiamond() {
			return collectedDiamond;
		}
		public static void setCollectedDiamond() {
			collectedDiamond ++;
		}
		public static boolean getOpen() {
			return open;
		}
		public static boolean getWin() {
			return win;
		}
		public static void setWin(boolean winner) {
		win = winner;
		}
}
