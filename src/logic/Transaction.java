package logic;

import java.time.LocalDate;


public class Transaction {
	LocalDate date;
	short accId;
	String Description;
	Categories type;
	float amount;
	boolean isIngreso;

	
	public Transaction(
			LocalDate date,
			short accId,
			String desc,
			Categories type, 
			float amount,
			boolean isIngreso
			)
	{
	this.date = date;
	this.accId = accId;
	this.Description = desc;
	this.type = type;
	this.amount = amount;
	this.isIngreso = isIngreso;		
	}
	
	public String transactionInfo() {
		return this.date + "; " + this.Description + "; " + this.type + "; " + this.amount + "; " + this.isIngreso + this.accId;
	}
}
