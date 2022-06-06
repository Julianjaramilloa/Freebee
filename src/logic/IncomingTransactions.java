package logic;

import java.time.LocalDate;

import rbTree.RedBlackTree;

public class IncomingTransactions {
	RedBlackTree incoming;
	
	public IncomingTransactions() {
		this.incoming = new RedBlackTree();
	}
	
	public void addTransaction(LocalDate date,Transaction transaction) {
		incoming.insertNode(date, transaction);
	}
}
