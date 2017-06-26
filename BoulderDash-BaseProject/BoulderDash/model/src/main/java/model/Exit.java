package model;


public class Exit extends Element implements IExit {
	private static int IMAGEPOSITIONX = 13;
	private static int IMAGEPOSITIONY = 1;
	private boolean open = false;
	private int collectedDiamond = 0;
	private static boolean win = false;
	private InbDiamond nbDiamond;
	public Exit(IPosition position) {
		super(position, IMAGEPOSITIONX, IMAGEPOSITIONY);
		this.gravity(position, map);
		this.move();
	}
	public void state(IMap map1) {
		if (this.nbDiamond.getNbdiamond() == this.getCollectedDiamond()) {
			this.open = true;
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
		public int getCollectedDiamond() {
			return collectedDiamond;
		}
		public void setCollectedDiamond() {
			collectedDiamond ++;
		}
		public boolean getOpen() {
			return open;
		}
		public boolean getWin() {
			return win;
		}
		public void setWin(boolean winner) {
		win = winner;
		}
		public void move() {
			this.move = new NoMove();
		}
		
}
