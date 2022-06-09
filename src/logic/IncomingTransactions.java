package logic;

import java.time.LocalDate;
import priorityQueue.MinHeap;
import seqDataStructures.LinkedList;

public class IncomingTransactions {
	
	private MinHeap<Transaction> incomingTransactions = new MinHeap<Transaction>();
	
	public void addIncomingTransaction(Transaction incoming) {
		LocalDate today = LocalDate.now();
		LocalDate transactionDate = incoming.getDate();
		
		if(today.compareTo(transactionDate) > 0) {
			throw new IllegalArgumentException ("Está intentando ingresar una transacción para una fecha que ya pasó");
		}else {
			this.incomingTransactions.add(incoming);
		}
	}
	
	public LinkedList<Transaction> popTransaction() {
		LinkedList<Transaction> transactionsToPop = new LinkedList<Transaction>();
		LocalDate today = LocalDate.now();
		
		boolean finished = false;
		while(!finished) {
			LocalDate peek = incomingTransactions.peek().getDate();
			if(peek.equals(today)) {
				transactionsToPop.pushBack(incomingTransactions.deleteMin());
			}else {
				finished = true;
			}
		}
		
		return transactionsToPop;
	}
	
}
