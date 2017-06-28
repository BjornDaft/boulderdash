package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DisplayTab extends Thread{

	private char charTabToDisplay[][];
	
	public DisplayTab(){
		super();
		this.start();
	}
	
	public void run(){
		
		while(true){
		decrypt();
		
		for(int i=0; i<this.charTabToDisplay.length; i++){		
			System.out.println();
			for(int j=0; j<this.charTabToDisplay.length; j++)
				System.out.print(charTabToDisplay[i][j]);
		}
			System.out.close();
		}
		
	}
	
	
	
	
	
	
	
	
	
	public void decrypt() {

		ObjectInputStream ois = null;

		try {
			final FileInputStream fichier = new FileInputStream("../model/tab");
			ois = new ObjectInputStream(fichier);
			final char chartabtest[][] = (char[][]) ois.readObject();
			
			this.charTabToDisplay = chartabtest;

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

