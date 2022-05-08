package logic;

import dataStructures.DynamicArray;
import dataStructures.LinkedList;

//Esta clase es el alma de la aplicación. Añadir Descripción
public class User {
	private String userName;
	private String password;
	private DynamicArray<Account> accounts = new DynamicArray<Account>(); 
	private LinkedList<Transaction> transactions = new LinkedList<Transaction>();
	private short idProvider = 0;
	
	protected User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	};
	
	protected void editAccounts() {
		
	};
	
	protected void addAccount(String name, float balance, float currency) {
		short id = idProvider;
		Account acc = new Account(id, name, balance, currency);
		idProvider ++;
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
}
