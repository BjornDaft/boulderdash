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


public class ExampleDAO {
	

	// to test : public static void main(final String argv[]) throws SQLException, IOException {
 	public static void getMap(int idLvl) throws SQLException, IOException{
 	// to test : int idLvl = "what you want to force to start"
    PrintWriter writer = null;
	try {
		writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("RECEIVED.txt"))));
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
    BoulderDashBDDConnector co = new BoulderDashBDDConnector();

    

    co.open();
    
    co.executeQuery("SELECT * FROM example");
    try (ResultSet resultSet = co.executeQuery("SELECT name FROM example WHERE id =" + idLvl)) {

    	while(resultSet.next()) { // for each row
 		   // take the blob
 		   Blob blob = resultSet.getBlob("name");
 		   BufferedInputStream is = new BufferedInputStream(blob.getBinaryStream());
 		   FileOutputStream fos = new FileOutputStream("RECEIVED.txt");
 		   // you can set the size of the buffer
 		   byte[] buffer = new byte[2048];
 		   int r = 0;
 		   while((r = is.read(buffer))!=-1) {
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
 
 decrypt();
 // use this to generate the map : generatelvl();   
    
}
  
public static void decrypt(){
		
	    ObjectInputStream ois = null;
	     

	    try {
	      final FileInputStream fichier = new FileInputStream("RECEIVED.txt");
	      ois = new ObjectInputStream(fichier);
	      final Map map1 = (Map) ois.readObject();
	      
	      System.out.println("Lvl name = " + map1.getName());
	      System.out.println("Id = " + map1.getId());
	      System.out.println("Nbdiamond = " + map1.getNbdiamond());
	      
	      System.out.println("width = " + map1.getWidth());
	      System.out.println("height = " + map1.getHeight());
	      System.out.println("code map = " + map1.getCodemap());
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
	


	public static void generatelvl(){
		
		
		
	    final Map map1 = new Map("LELELE", 10, 18, 12, "REOOOOOOOOOOOOOOORPREOOOOOOOOOOOOORSDOREOOOOOOOOOOORODRDOREOOOOOOOOORODRORDOREOOOOOOORODROOORDOREOOOOORODROOOOORDOREOOORODROOOOOOORDOREORODROOOOOOOOORDORRODROOOOOOOOOOORDOOOROOOOOO", 1);
	    ObjectOutputStream oos = null;
	    PrintWriter writer = null;
		try {
			writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("RECEIVED.txt"))));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	    try {
	      final FileOutputStream fichier = new FileOutputStream("donnees.txt");
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

