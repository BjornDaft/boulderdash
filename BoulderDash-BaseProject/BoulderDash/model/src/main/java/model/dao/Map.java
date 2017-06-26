package model.dao;

import java.io.Serializable;

import model.InbDiamond;

@SuppressWarnings("serial")
public class Map implements Serializable,InbDiamond {

	private String name;
	private int id;
	private int width;
    private int height;
    private String mapCode;
    private int nbdiamond;



    public Map(final String name, final int id,final int width, final int height, final String codemap, final int nbdiamond){
	
    this.name = name;
    this.id = id;	
    this.width = width;
	this.height = height;
	this.mapCode = codemap;
	this.nbdiamond = nbdiamond;
    }


    public int getHeight(){
	return this.height;
    }

    public int getWidth(){
	return this.width;
    }
  
  public String getMapCode() {
    return this.mapCode;
  }
  
  public int getId(){
	  return this.id;
  }
  
  public int getNbdiamond(){
	  return this.nbdiamond;
  }
  
  public String getName(){
	  return this.name;
  }
 }

