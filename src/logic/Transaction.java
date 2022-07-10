package logic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class Transaction implements Comparable<Transaction>{
	LocalDate date;
	int accountId;
	int transactionId;
	String Description;
	TransactionCategory type;
	float amount;
	boolean isIngreso;

	
	public Transaction(
			LocalDate date,
			int accountId,
			int transactionId,
			String description,
			TransactionCategory type, 
			float amount,
			boolean isIngreso
			)
	{
	this.date = date;
	this.accountId = accountId;
	this.transactionId = transactionId;
	this.Description = description;
	this.type = type;
	this.amount = amount;
	this.isIngreso = isIngreso;		
	}

	@Override
	public int compareTo(Transaction o) {
		int comparison = this.date.compareTo(o.date);
		
		//Criterio de desempate (id de la cuenta):
		if(comparison == 0) {
			if(this.accountId == o.accountId){
				comparison = 0;
			}else if(this.accountId > o.accountId) {
				comparison = 1;
			}else{
				comparison = -1;
			}
		}
		//Segundo desempate (id de la transacción)
		if(comparison == 0) {
			if(this.transactionId == o.transactionId){
				comparison = 0;
			}else if(this.transactionId > o.transactionId) {
				comparison = 1;
			}else{
				comparison = -1;
			}
		}
		
		return comparison;
	}
	
	//Getters
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public String getDescription() {
		return this.Description;
	}
	
	public String getCategory() {
		return type.toString();
	}
	
	public String isIngreso() {
		if(isIngreso) {
			return "+";
		}else {
			return "-";
		}
	}

	public boolean getBoolean() {
		return isIngreso;
	}
	

	@Override
	public String toString() {
		String ingreso = null;
		if(isIngreso) {
			ingreso = "Ingreso";
		}else {
			ingreso = "Egreso";
		}
		return  date + "; " + 
				Description + "; " 
				+ type + "; " 
				+ amount + "; " 
				+ ingreso
				+ "; Id Cuenta: " + accountId 
				+ "; Id transacción " + transactionId;
	}
	
	public String saveData() {
		DateTimeFormatter df = new DateTimeFormatterBuilder()
			    // case insensitive to parse JAN and FEB
			    .parseCaseInsensitive()
			    // add pattern
			    .appendPattern("dd-MM-yyyy")
			    // create formatter (use English Locale to parse month names)
			    .toFormatter(Locale.ENGLISH);
		return date.format(df) + ";" + Description +";" + type + ";" + amount + ";" + isIngreso + ";" + accountId;
	}
	
}
