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
	
	public boolean id(short id) {
		if(this.accId == id) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Transaction [date=" + date + ", accId=" + accId + ", Description=" + Description + ", type=" + type
				+ ", amount=" + amount + ", isIngreso=" + isIngreso + "]";
	}
	
	
}
