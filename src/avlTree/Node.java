package avlTree;

public class Node<T> {
	  T data;

	  Node<T> left;
	  Node<T> right;
	  Node<T> parent;

	  int height;

	  public Node(T data) {
	    this.data = data;
	  }

	  @Override
	  public String toString() {
		  return String.valueOf(data);
	  }
	  
	}