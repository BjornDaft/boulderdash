package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */

public class ModelFacade implements Serializable, IModelFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9078656111651506140L;
	/**
	 * Instantiates a new model facade.
	 */
	private char chartab[][];
	private Object tab[][];
	// ModelFacade array = new ModelFacade(2, 2, "AAAA");

	public ModelFacade(final int width, final int height, final String string) {
		this.chartab = new char[width][height];
		this.tab = new Object[width][height];
		try {
			int a = 0, i = 0, j = 0;
			char n;
			if (string.length() != width * height) {
				throw new Exception(

						"Inexact number of chars, there are " + string.length() + " in place of " + width * height);
			}

			for (j = 0; j < height; j++) {
				for (i = 0; i < width; i++) {

					n = string.charAt(a);
					switch (n) {
					case 'O':

						this.tab[i][j] = new Mud(new Position(i, j));

						this.chartab[j][i] = n;
						break;
					case 'W':

						this.tab[i][j] = new Wall(new Position(i, j));

						this.chartab[j][i] = n;
						break;
					case 'R':

						this.tab[i][j] = new Rock(new Position(i, j));
						this.chartab[j][i] = n;
						break;
					case 'E':

						this.tab[i][j] = new Enemy(new Position(i, j), null);
						this.chartab[j][i] = n;
						break;
					case 'D':

						this.tab[i][j] = new Diamond(new Position(i, j));
						this.chartab[j][i] = n;
						break;
					case 'X':

						this.tab[i][j] = new Empty(new Position(i, j));

						this.chartab[j][i] = n;
						break;
					case 'P':

						this.tab[i][j] = new Player(new Position(i, j), "UP");
						this.chartab[j][i] = n;
						break;
					case 'S':

						this.tab[i][j] = new Exit(new Position(i, j));
						this.chartab[j][i] = n;
						break;
					default:
						a++;
						throw new Exception("Unrecognized char at position " + a + "(that's a " + n + ")");
					}
					a++;
				}
			}
		} catch (Exception e) {

			System.err.println(e.getMessage());
			System.exit(1);
		}
		generateArrayMap(chartab);
		decrypt();
	}

	// to serial HERE !! Because InterLulz don't work.

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
				this.tab[i][j] = new Enemy(new Position(i, j), null);
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

	/*
	 * public ModelFacade() { this.mobiles = new ArrayList<>(); }
	 * 
	 * 
	 * public void addMobile(IMobile mobile) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void removeMobile(IMobile mobile) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public ArrayList<IMobile> getMobiles() { // TODO Auto-generated
	 * method stub return this.mobiles; }
	 */
	@Override
	public char[][] getCharTab() {
		// TODO Auto-generated method stub
		return this.chartab;
	}

	@Override
	public Object[][] getTab() {
		// TODO Auto-generated method stub
		return this.tab;
	}

	public static void generateArrayMap(char chartab[][]) {

		ObjectOutputStream oos = null;

		try {
			final FileOutputStream fichier = new FileOutputStream("tab");
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(chartab);
			oos.flush();
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void decrypt() {

		ObjectInputStream ois = null;

		try {
			final FileInputStream fichier = new FileInputStream("tab");
			ois = new ObjectInputStream(fichier);
			final char chartabtest[][] = (char[][]) ois.readObject();
			
			System.out.println("Test = " + chartabtest[0][0]);
			System.out.println("Test = " + chartabtest[0][1]);

		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException f) {
			f.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
