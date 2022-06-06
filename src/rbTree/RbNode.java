package rbTree;

import java.time.LocalDate;

public class RbNode {
	  LocalDate date;
	  int data;
	  RbNode left;
	  RbNode right;
	  RbNode parent;

	  //Hay que resolver cómo hacer nodos diferentes para
	  //el AVL y el Rojo-Negro
	  int height; //Avl
	  boolean color; //Rojo Negro


	  public RbNode(LocalDate date) {
	    this.date = date;
	  }
	  

	public RbNode(int i) {
		this.data = i;
	}


	//Hago aquí el toString() para debuggear
	  @Override
	  public String toString() {
		  return String.valueOf(date);
	  }
	  
	}