package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */

public class ModelFacade implements Serializable, IModelFacade {

	private IExit exit;
	private IPlayer player;
	private IMap map;
	/**
	 * 
	 */
	private static final long serialVersionUID = -9078656111651506140L;
	/**
	 * Instantiates a new model facade.
	 */
	
	// ModelFacade array = new ModelFacade(2, 2, "AAAA");

	public ModelFacade(IMap map) {
		this.map = map;
	}

	// to serial HERE !! Because InterLulz don't work.


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
	}*/

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
	
/*@Override
	public IElement[] getElement() {
		ArrayList<Element> list = new ArrayList<Element>();
		for(int i = 0; i < this.tab.length; i++) {
	        for(int j = 0; j < this.tab[i].length; j++){
	            list.add((Element) this.tab[i][j]);
	        }
	    }
		return list.toArray(new IElement[0]);
	}*/
	public boolean isGameOver() {
		if (player.getIsAlive() == false || this.exit.getWin() == true) {
			return true;
		}
		return false;
	}

	@Override
	public IPosition getPosition(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMap getMap() {
		// TODO Auto-generated method stub
		return this.map;
	}

	@Override
	public ArrayList<IElement> createElements() {
		// TODO Auto-generated method stub
		return null;
	}
}
