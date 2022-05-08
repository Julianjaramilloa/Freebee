package logic;

import java.time.LocalDate;

import dataStructures.DynamicArray;
import dataStructures.LinkedList;

//Esta clase es el alma de la aplicación. Añadir Descripción
public class User {
	private String userName;
	private String password;
	public DynamicArray<Account> accounts = new DynamicArray<Account>(); 
	public LinkedList<Transaction> transactions = new LinkedList<Transaction>();
	private short idProvider = 0;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	};
	
	
	protected void editAccounts() {
		
	};
	
	public void addAccount(String name, float balance, String currency) {
		short id = idProvider;
		Account acc = new Account(id, name, balance, currency);
		accounts.pushBack(acc);
		idProvider ++;
	}
	
	public void addTransaction(
			LocalDate date,
			short accId,
			String desc,
			Categories type, 
			float amount,
			boolean isIngreso) {
		Transaction trans = new Transaction(
				date,
				accId,
				desc,
				type,
				amount,
				isIngreso);
		transactions.pushBack(trans); //Toca hacer una verificación de si la cuenta existe
	}
	
	protected String getUserName() {
		return this.userName;
	}
	
	protected boolean right(String userName, String password) {
		boolean right = false;
		
		if(this.userName.equals(userName)) {
			if(this.password.equals(password)) {
				right = true;
			}
		}else {
			right = false;
		}
		return right;
	};
	
	@Override
	public String toString() {
		return "Us: " + userName;
	}
	
	public Account getAccounts(int index)
	{		
		return accounts.get(index);
	}
	
	public Transaction getTransactions(int index)
	{		
		return transactions.get(index);
	}
	
	public String completeUserInfo() {
		return null;	
		
			
		
	}

	public String userAndPassword() {
		return this.userName + "; " + this.password;	
		}
}
