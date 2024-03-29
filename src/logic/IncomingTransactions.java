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
			throw new IllegalArgumentException ("Est� intentando ingresar una transacci�n para una fecha que ya pas�");
		}else {
			this.incomingTransactions.add(incoming);
		}
	}
	
	public LinkedList<Transaction> popTransaction() {
		LinkedList<Transaction> transactionsToPop = new LinkedList<Transaction>();
		LocalDate today = LocalDate.now();
		
		boolean finished = false;
		while(!finished) {
			Transaction peek = incomingTransactions.peek();
			if (peek == null) {
				finished = true;
			}else {
				LocalDate peekDate = incomingTransactions.peek().getDate();
				if(peekDate.equals(today) || peekDate.compareTo(today) < 0) {
					transactionsToPop.pushBack(incomingTransactions.deleteMin());
				}else {
					finished = true;
				}				
			}

		}
		
		return transactionsToPop;
	}
	
}
