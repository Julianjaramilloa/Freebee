package trees;

public class Node {
	  int data;

	  Node left;
	  Node right;
	  Node parent;

	  //Hay que resolver cómo hacer nodos diferentes para
	  //el AVL y el Rojo-Negro
	  int height; //Avl
	  boolean color; //Rojo Negro

	  public Node(int data) {
	    this.data = data;
	  }
	  
	  
	  //Hago aquí el toString() para debuggear
	  @Override
	  public String toString() {
		  return String.valueOf(data);
	  }
	  
	}