package model.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.IMap;

public class MapDAO implements IMap{

	private char tab[][];

	public void buildtab(final int width, final int height, final String string) {
		this.tab = new char[width][height];
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
					if (n == 'O' || n == 'W' || n == 'R' || n == 'E' || n == 'D' || n == 'X' || n == 'P' || n == 'S') {
						this.tab[j][i] = n;
						a++;
					} else {
						throw new Exception("Unrecognized char at position " + a + "(that's a " + n + ")");
					}
					a++;
				}
			}
		} catch (Exception e) {

			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Get the map
	 * @return tab
	 */
	public char[][] getTab() {
		return this.tab;
	}

	/**
	 * Set a map
	 * @param map
	 * 			the sat map
	 */
	public void setMap(char[][] map) {
		this.tab = map;
	}

	/**
	 * Get a char from the map
	 * @param x
	 * @param y
	 * @return
	 */
	public char getChar(final int x, final int y) {
		return this.tab[x][y];
	}

	/**
	 * Set a char in the map
	 * @param x
	 * 		The coord x
	 * @param y
	 * 		The coord y
	 * @param c
	 * 		The char to set
	 */
	public void setChar(final int x, final int y, final char c) {
		this.tab[x][y] = c;
	}

	/**
	 * This function will received the serialized map from database.
	 * 
	 * @param idLvl
	 *            Id du niveau choisi.
	 */
	public void getMap(int idLvl) throws SQLException, IOException {
		// to test : int idLvl = "what you want to force to start"
		// to test : public static void main(final String argv[]) throws
		// SQLException, IOException {

		PrintWriter writer = null;
		try {
			writer = new PrintWriter(
					new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("RECEIVED.txt"))));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BoulderDashBDDConnector co = new BoulderDashBDDConnector(); // Initializing
																	// connection

		co.open(); // Make connection

		co.executeQuery("SELECT * FROM example");
		try (ResultSet resultSet = co.executeQuery("SELECT name FROM example WHERE id =" + idLvl)) {

			while (resultSet.next()) {

				Blob blob = resultSet.getBlob("name");
				BufferedInputStream is = new BufferedInputStream(blob.getBinaryStream());
				FileOutputStream fos = new FileOutputStream("RECEIVED.txt");

				byte[] buffer = new byte[2048];
				int r = 0;
				while ((r = is.read(buffer)) != -1) {
					fos.write(buffer, 0, r);
				}
				fos.flush();
				fos.close();
				is.close();
				blob.free();
			}
			resultSet.close();
			writer.flush();
			writer.close();
		}


	}

	/**
	 * This function will create an object map1 from binary received
	 */
	public void decrypt() {

		ObjectInputStream ois = null;

		try {
			final FileInputStream fichier = new FileInputStream("../main/RECEIVED.txt");
			ois = new ObjectInputStream(fichier);
			final Map map1 = (Map) ois.readObject();

			System.out.println("Lvl name = " + map1.getName());
			System.out.println("Id = " + map1.getId());
			System.out.println("Nbdiamond = " + map1.getNbdiamond());
			System.out.println("width = " + map1.getWidth());
			System.out.println("height = " + map1.getHeight());
			System.out.println("code map = " + map1.getMapCode());

			int width = map1.getWidth();
			int height = map1.getHeight();
			String mapCode = map1.getMapCode();

			this.buildtab(width, height, mapCode);
			// This function will get the mapCode, then create an array of
			// object using width and height

		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
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

	/**
	 * Test function, used to generate a binary of the map
	 */
	public void generatelvl() {

		final Map map1 = new Map("LELELE", 10, 18, 12, "REOOOOOOOOOOOOOOORPREOOOOOOOOOOOOORSDOREOOOOOOOOOOORODRDOREOOOOOOOOORODRORDOREOOOOOOORODROOORDOREOOOOORODROOOOORDOREOOORODROOOOOOORDOREORODROOOOOOOOORDORRODROOOOOOOOOOORDOOOROOOOOO000000000000000000000000000000000000",1);
		ObjectOutputStream oos = null;
		@SuppressWarnings("unused")
		PrintWriter writer = null;

		try {
			final FileOutputStream fichier = new FileOutputStream("GeneratedLVL");
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(map1);
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
}