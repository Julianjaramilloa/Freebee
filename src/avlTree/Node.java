package avlTree;

public class Node {
	  int data;

	  Node left;
	  Node right;
	  Node parent;

	  int height; //Avl

	  public Node(int data) {
	    this.data = data;
	  }
	  
	  
	  //Hago aquí el toString() para debuggear
	  @Override
	  public String toString() {
		  return String.valueOf(data);
	  }
	  
	}