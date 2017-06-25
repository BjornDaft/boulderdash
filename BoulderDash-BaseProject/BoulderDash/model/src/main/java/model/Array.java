package model;

public class Array {

	private char chartab[][];
	private Object tab[][];

	public Array(final int x, final int y,final String c) {
		ModelFacade model = new ModelFacade(x,y,c);
		this.chartab = model.getCharTab();
		this.tab = model.getTab();
	}

	public char getChar(final int x, final int y) {
		return this.chartab[x][y];
	}

	public void setChar(final int x, final int y, final char c) {
		this.chartab[x][y] = c;
	}

	public String getType(final int x, final int y) {
		if (tab[x][y] instanceof Mud)
			return "Mud";
		else if (tab[x][y] instanceof Wall)
			return "Wall";
		else if (tab[x][y] instanceof Rock)
			return "Rock";
		else if (tab[x][y] instanceof Enemy)
			return "Enemy";
		else if (tab[x][y] instanceof Diamond)
			return "Diamond";
		else if (tab[x][y] instanceof Empty)
			return "Empty";
		else if (tab[x][y] instanceof Player)
			return "Player";
		else if (tab[x][y] instanceof Exit)
			return "Exit";
		else
			return "";

	}

	public void setType(final int i, final int j, final char c) {
		this.chartab[i][j] = c;
		this.tab[i][j] = null;
		try {
			switch (c) {
			case 'O':
				this.tab[i][j] = new Mud(new Position(i, j));
				break;
			case 'W':
				this.tab[i][j] = new Wall(new Position(i, j));
				break;
			case 'R':
				this.tab[i][j] = new Rock(new Position(i, j));
				break;
			case 'E':
				this.tab[i][j] = new Enemy(new Position(i, j));
				break;
			case 'D':
				this.tab[i][j] = new Diamond(new Position(i, j));
				break;
			case 'X':
				this.tab[i][j] = new Empty(new Position(i, j));
				break;
			case 'P':
				this.tab[i][j] = new Player(new Position(i, j), "UP");
				break;
			case 'S':
				this.tab[i][j] = new Exit(new Position(i, j));
				break;
			default:
				throw new Exception("Unrecognized char (that's a " + c + ")");
			}
		} catch (Exception e) {

			System.err.println(e.getMessage());
			System.exit(1);
		}

	}

}
