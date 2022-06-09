package runner;


import seqDataStructures.DynamicArray;
import seqDataStructures.DynamicArrayIterator;
import seqDataStructures.Iterator;
import seqDataStructures.LinkedList;
import seqDataStructures.LinkedListIterator;
import ui.LogIn;
import ui.ReaderWriter;

import java.time.LocalDate;

import avlTree.AVLTree;
import logic.Transaction;
import logic.TransactionCategory;
import logic.User;
import logic.UserList;
import priorityQueue.MinHeap;
import rbTree.RbNode;
import rbTree.RedBlackTree;
//Esta clase la cree para ir probando que las cosas que vamos creando funcionan

public class TestClasses {
	
	void minHeap () {
		MinHeap<Integer> mh = new MinHeap<Integer>();
		
		DynamicArray<Integer> da = new DynamicArray<Integer>();
		
		da.pushBack(78);
		da.pushBack(98);
		da.pushBack(12);
		da.pushBack(70);
		da.pushBack(654);
		da.pushBack(9);
		da.pushBack(4);
		da.pushBack(2967);
		da.pushBack(6);
		da.pushBack(546);
		da.pushBack(8);
		da.pushBack(3);
		da.pushBack(721);
		da.pushBack(168765);
		da.pushBack(7943);
		da.pushBack(6464);
		
		DynamicArrayIterator <Integer> dai = new DynamicArrayIterator<Integer>(da);
		
		System.out.println("Orden de inserci�n \n" + da.toString());
		while(dai.hasNext()) {
			int include = dai.next();
			
			mh.add(include);
			System.out.println(mh.toString());
		}
		
		for (int i=0; i<5; i++) {
			int deleted = mh.deleteMin();
			System.out.println("Deleted: " + deleted + "\n" + mh.toString());
		}
		
	}
	
	
	void avlTree () {
		
		/*AVLTree<Integer> avl = new AVLTree<Integer>();
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
		
		System.out.println("Orden de inserci�n:\n" + treeNodes.toString() + "\n");
		
		Iterator<Integer> it = new LinkedListIterator<Integer>(treeNodes);
		while(it.hasNext()) {
			int toInsert = it.next();
			avl.insertNode(toInsert);
		}
		System.out.println("�rbol:\n" + avl.toString());
		
		LinkedList<Integer> deletions = new LinkedList<Integer>();
		
		deletions.pushBack(60);
		deletions.pushBack(89);
		deletions.pushBack(27);
		deletions.pushBack(789);
		
		
		Iterator<Integer> dl = new LinkedListIterator<Integer>(deletions);
		while(dl.hasNext()) {
			int toInsert = dl.next();
			System.out.println("Deletion: " + toInsert);
			avl.deleteNode(toInsert);
			System.out.println("�rbol:\n" + avl.toString());
		}
		
		*/
//		System.out.println("�rbol:\n" + avl.toString());
		
		
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
	
	private TransactionCategory ts(String toParse) {
		return TransactionCategory.valueOf(toParse);
	}
	
	public void userTransactions() {
		User us = new User("cesar", "1234");
		UserList ul = new UserList();
		
		us.addTransactionData(LocalDate.of(2002, 10, 19), 1, "Pago del inmueble", ts("Vivienda"), 40500000, false);
		AVLTree<Transaction> av = us.getTransactions();
		System.out.println(av.toString());
		
		ReaderWriter rd = new ReaderWriter(ul);
		rd.readFile(); 
		RedBlackTree rbt = UserList.users;
		RbNode rb = rbt.searchNode("Usuario11");
		User user = rb.getUser();
		System.out.println(user.completeUserInfo());
		
		//AVLTree<Transaction> xdUs = xd.getTransactions();
		//System.out.println(xdUs.preorderTraverse());
	}
	
	public void incomingTransactionsTest() {
		User us = new User("daniel", "789uio");
		UserList ul = new UserList();
		ul.addUser(us);
		System.out.println(us.addAccount("Cuenta Bancolombia", 2500000, "Peso colombiano"));
		us.addTransactionData(LocalDate.of(2022, 4, 15), 1, "Gasto compra insumos", ts("Trabajo"), 615200, false);
		try{
			us.addIncomingTransaction(LocalDate.now(), 1, "Emprendimiento", ts("Ingresos"), 500000, true);
		}catch (IllegalArgumentException iae) {
			System.out.println(iae.toString());
		}
		
		System.out.println(us.completeUserInfo());
		LogIn lg = new LogIn(ul);
		lg.credentialsIn();
		
	}
	
	
	
}
