package logic;

import java.time.LocalDate;

public class Transaction implements Comparable<Transaction>{
	LocalDate date;
	int accountId;
	String Description;
	TransactionCategory type;
	float amount;
	boolean isIngreso;

	
	public Transaction(
			LocalDate date,
			int accountId,
			String description,
			TransactionCategory type, 
			float amount,
			boolean isIngreso
			)
	{
	this.date = date;
	this.accountId = accountId;
	this.Description = description;
	this.type = type;
	this.amount = amount;
	this.isIngreso = isIngreso;		
	}
	
	public boolean id(int id) {
		if(this.accountId == id) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		String ingreso = null;
		if(isIngreso) {
			ingreso += "Ingreso";
		}else {
			ingreso += "Egreso";
		}
		return  "Transaction: " + date + "; " + Description + "; " + type + "; " + amount + "; " + ingreso + "; " + accountId;
	}

	@Override
	public int compareTo(Transaction o) {
		int comparison = this.date.compareTo(o.date);
		
		String a = "as";
		String b = "bro";
		System.out.println(a.compareTo(b));
		
		//Criterio de desempate:
		if(comparison == 0) {
			if(this.accountId == o.accountId){
				comparison = 0;
			}else if(this.accountId > o.accountId) {
				comparison = 1;
			}else {
				comparison = -1;
			}
		}
		
		return comparison;
	}
	
	
	
}
