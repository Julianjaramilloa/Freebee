package avlTree;

import seqDataStructures.LinkedList;

public class AVLTreeInList<T extends Comparable<T>> {
	
	private Node<T> root;
	private LinkedList<T> nodes = new LinkedList<T>();
	
	//Recorrer el árbol en preorden y luego llena una lista enlazada que se itera
    public AVLTreeInList(AVLTree<T> avl) {
    	this.root = avl.root;
    	preorderTraverse();
    }
	
    public LinkedList<T> getList(){
    	return this.nodes;
    }
    
	private void preorderTraverse() {
		if(root != null) {
			addNodesInPreorder(root);
		}
	}
    
	private void addNodesInPreorder(Node<T> node) {
		    nodes.pushBack(node.data);
		    if (node.left != null) {
		      addNodesInPreorder(node.left);
		    }
		    if (node.right != null) {
		      addNodesInPreorder(node.right);
		    }
	  }
	
	

}
