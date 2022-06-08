package runner;


import seqDataStructures.Iterator;
import seqDataStructures.LinkedList;
import seqDataStructures.LinkedListIterator;
import avlTree.AVLTree;
import rbTree.RedBlackTree;
//Esta clase la cree para ir probando que las cosas que vamos creando funcionan

public class ProveClasses {
	
	
	void avlTree () {
		AVLTree avl = new AVLTree();
		LinkedList<Integer> treeNodes = new LinkedList<Integer>();
		
		treeNodes.pushBack(89);
		treeNodes.pushBack(60);
		treeNodes.pushBack(27);
		treeNodes.pushBack(01);
		treeNodes.pushBack(36);
		treeNodes.pushBack(789);
		treeNodes.pushBack(41);
		treeNodes.pushBack(2);
		treeNodes.pushBack(40);
		treeNodes.pushBack(9);
		treeNodes.pushBack(81);
		treeNodes.pushBack(79);
		treeNodes.pushBack(51);
		
		System.out.println("Orden de inserción:\n" + treeNodes.toString() + "\n");
		
		Iterator<Integer> it = new LinkedListIterator<Integer>(treeNodes);
		while(it.hasNext()) {
			int toInsert = it.next();
			avl.insertNode(toInsert);
		}
		System.out.println("Árbol:\n" + avl.toString());
		
		LinkedList<Integer> deletions = new LinkedList<Integer>();
		deletions.pushBack(89);
		deletions.pushBack(27);
		
		Iterator<Integer> dl = new LinkedListIterator<Integer>(deletions);
		while(dl.hasNext()) {
			int toInsert = dl.next();
			avl.deleteNode(toInsert);
			System.out.println("Árbol:\n" + avl.toString());
		}
//		System.out.println("Árbol:\n" + avl.toString());
		
		
		/*AVLTree avl = new AVLTree();
		avl.insertNode(98);
		avl.insertNode(156);
		avl.insertNode(27);
		avl.insertNode(35);
		avl.insertNode(234);
		avl.insertNode(350);
		avl.insertNode(32);*/
		//avl.insertNode(12);

		
		/*AVLTree avl = new AVLTree();
		avl.insertNode(98);
		avl.insertNode(156);
		avl.insertNode(273);
		avl.insertNode(74);
		avl.insertNode(78);
		avl.insertNode(789);
		avl.insertNode(56);
		avl.insertNode(898);
		avl.insertNode(67);
		avl.insertNode(92);
		avl.insertNode(4);
		avl.insertNode(31);
		avl.insertNode(15);
		avl.insertNode(19);
		avl.insertNode(79);
		*/
		 		
	}
	
	void rbTree() {
		RedBlackTree rbt = new RedBlackTree();
		
//		rbt.insertNode(89);
//		rbt.insertNode(60);
//		rbt.insertNode(27);
//		rbt.insertNode(01);
//		rbt.insertNode(36);
//		rbt.insertNode(789);
		
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
