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

import model.Diamond;
import model.Empty;
import model.Ennemy;
import model.Exit;
import model.Mud;
import model.Player;
import model.Rock;
import model.Wall;


public class ExampleDAO {
	

	/**
	 * This function will received the serialized map from database.
	 * @param idLvl 	Id du niveau choisi.
	 */
 	public static void getMap(int idLvl) throws SQLException, IOException{
 	// to test : int idLvl = "what you want to force to start"
    // to test : public static void main(final String argv[]) throws SQLException, IOException {
 	
    PrintWriter writer = null;
	try {
		writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("RECEIVED.txt"))));
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
    BoulderDashBDDConnector co = new BoulderDashBDDConnector(); // Initializing connection

    

    co.open(); // Make connection
    
    co.executeQuery("SELECT * FROM example");
    try (ResultSet resultSet = co.executeQuery("SELECT name FROM example WHERE id =" + idLvl)) {

    	while(resultSet.next()) {

 		   Blob blob = resultSet.getBlob("name");
 		   BufferedInputStream is = new BufferedInputStream(blob.getBinaryStream());
 		   FileOutputStream fos = new FileOutputStream("RECEIVED.txt");

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
  
	/**
	 * This function will create an object map1 from binary received
	 */
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
	      System.out.println("code map = " + map1.getMapCode());
	      
		  int width = map1.getWidth();
		  int height = map1.getHeight();
		  String mapCode = map1.getMapCode();
		  
		  generateObjectsFromMap(width, height, mapCode);
		  // This function will get the mapCode, then create an array of object using width and height
	      
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
	
	/**
	 * This function will get the mapCode, then create an array of object using width and height, only used into decrypt().
	 * @param width 	Longueur du niveau choisi.
	 * @param height 	Hauteur du niveau choisi.
	 * @param string 	mapCode du niveau choisi.
	 */
	 public static void generateObjectsFromMap(int width, int height, String string){

		 int a=0,i=0,j=0;
	        
	        char n;

	        Object[][] tab= new Object[width][height];

	        try{
	            if (string.length()!=width*height){
	                throw new Exception("Inexact number of chars, there are "+string.length()+" in place of "+width*height);
	            }

	            for(j=0;j<height;j++){
	                for(i=0;i<width;i++){
	                    
	                    n=string.charAt(a);
	                    if (n=='O'){
	                        tab[i][j]=new Mud(i,j);
	                    }
	                    else if (n=='W'){
	                        tab[i][j]=new Wall(i,j);
	                    }
	                    else if (n=='R'){
	                        tab[i][j]=new Rock(i,j);
	                    }
	                    else if (n=='E'){
	                        tab[i][j]=new Ennemy(i,j);
	                    }
	                    else if (n=='D'){
	                        tab[i][j]=new Diamond(i,j);
	                    }
	                    else if (n=='X'){
	                        tab[i][j]=new Empty(i,j);
	                    }
	                    else if (n=='P'){
	                        tab[i][j]=new Player(i,j);
	                    }
	                    else if (n=='S'){
	                        tab[i][j]=new Exit(i,j);
	                    }
	                    else{
	                        a++;
	                        throw new Exception("Unrecognized char at position "+a+" (that's a "+n+")");
	                    }
	                    a++;
	                }
	            }
	        }
	        catch(Exception e) {
	            System.err.println(e.getMessage());
	            System.exit(1);
	    }
		 
		 
		 
		 
	 }

	
	
}

