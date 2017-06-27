package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DisplayTab {

	
	
	
	
	
	
	
	
	public static void decrypt() {

		ObjectInputStream ois = null;

		try {
			final FileInputStream fichier = new FileInputStream("../model/tab");
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

