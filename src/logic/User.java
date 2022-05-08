package logic;

import dataStructures.DynamicArray;
import dataStructures.LinkedList;

//Esta clase es el alma de la aplicación. Añadir Descripción
class User {
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
	
	protected boolean login(String userName, String password) {
		boolean rightCred = false;
		
		if(this.userName == userName) {
			if(this.password == password) {
				rightCred = true;
			}
		}else {
			rightCred = false;
		}
		return rightCred;
	}

	@Override
	public String toString() {
		return "us: " + userName + ", acc:" + accounts.size() + ", trans: " + transactions.size();
	};
	

		
}
