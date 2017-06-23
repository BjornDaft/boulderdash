package model;

import model.dao.Map;



public class Exit extends Element {
	private static int IMAGEPOSITIONX = 13;
	private static int IMAGEPOSITIONY = 1;
	private static boolean open = false;
	private static int collectedDiamond = 0;
	
	public Exit(Position position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
	}
	public void state(Map map1) {
		if (map1.getNbdiamond() == getCollectedDiamond()) {
			open = true;
			}
		}
	public void win(Position position, Array array) {
		if (array.getType(this.position.getX(), this.position.getY()) == "Player" && open == true) {
			System.exit(0);
		}
	}
		@Override
		public void gravity(Position position, Array array) {
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
}
