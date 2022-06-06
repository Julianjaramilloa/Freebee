package rbTree;

import java.time.LocalDate;

import logic.Transaction;

public class RbNode {
	  LocalDate date;
	  int data;
	  Transaction transaction;
	  RbNode left;
	  RbNode right;
	  RbNode parent;


	  boolean color; 


	  public RbNode(LocalDate date,Transaction transaction ) {
	    this.date = date;
	    this.transaction = transaction;
	  }
	  

	  public RbNode(int i) {
		this.data = i;
	  }


	//Hago aquí el toString() para debuggear
	  @Override
	  public String toString() {
		  return String.valueOf(date);
	  }
	  
	}