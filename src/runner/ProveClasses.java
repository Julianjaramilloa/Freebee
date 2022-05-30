package runner;


import seqDataStructures.LinkedList;
import trees.AVLTree;
import trees.RedBlackTree;
//Esta clase la cree para ir probando que las cosas que vamos creando funcionan

public class ProveClasses {
	
	
	void avlTree () {
		AVLTree avl = new AVLTree();
		avl.insertNode(89);
		avl.insertNode(60);
		avl.insertNode(27);
		avl.insertNode(01);
		avl.insertNode(36);
		avl.insertNode(789);
		
		System.out.println(avl.toString());
	}
	
	void rbTree() {
		RedBlackTree rbt = new RedBlackTree();
		
		rbt.insertNode(89);
		rbt.insertNode(60);
		rbt.insertNode(27);
		rbt.insertNode(01);
		rbt.insertNode(36);
		rbt.insertNode(789);
		
		System.out.println(rbt.toString());
	}
	
	void linkedListInsertions() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		System.out.println(ll.toString());
		ll.add(85, 0);
		System.out.println(ll.toString());
		ll.add(44, 1);
		ll.add(78, 1);
		System.out.println(ll.toString());
		ll.add(72, 0);
		ll.add(65, 0);
		ll.add(9, 0);
		ll.add(12, 0);
		ll.add(45, 2);
		ll.add(77, 6);
		ll.add(1034, 6);
		System.out.println(ll);

		
	}
}
