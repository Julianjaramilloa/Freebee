package logic;

import java.time.LocalDate;
import java.time.LocalDateTime;

import avlTree.AVLTree;
import seqDataStructures.DynamicArray;
import seqDataStructures.DynamicArrayIterator;
import seqDataStructures.LinkedList;
import seqDataStructures.LinkedListIterator;

//Esta clase es el alma de la aplicación.
public class User {
	private String username;
	private String password;
	private DynamicArray<Account> accounts = new DynamicArray<Account>(); 
	private AVLTree<Transaction> transactions = new AVLTree<Transaction>();
	@SuppressWarnings("unused")
	private IncomingTransactions inc;//Implementación a futuro
	private short idProvider = 0;
	
	public DynamicArray<Account> getAccounts() {
		return this.accounts;
	}
	
	public AVLTree<Transaction> getTransactions() {
		return this.transactions;
	}
	
	public User(String userName, String password) {
		this.username = userName;
		this.password = password;
	};
	
	public void addAccount(String name, float balance, String currency) {
		short id = idProvider;
		Account acc = new Account(id, name, balance, currency);
		accounts.pushBack(acc);
		idProvider ++;
	}
	
	public void addTransaction(
			LocalDate date,
			int accId,
			String desc,
			TransactionCategory type, 
			float amount,
			boolean isIngreso) {
		Transaction trans = new Transaction(
				date,
				accId,
				desc,
				type,
				amount,
				isIngreso);
		try{
			transactions.insertNode(trans); //Toca hacer una verificación de si la cuenta existe
		}catch(IllegalArgumentException iae) {
			System.out.println("La transacción ya existe");
		}
	}
	
	public String getUsername() {
		return this.username;
	}
	
	protected boolean areRightCredentials(String userName, String password) {
		boolean right = false;
		
		if(this.username.equals(userName)) {
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
		return username;
	}
	
	public void setBalance(int id) {
		
	}
	
	public String accountsInfo(int id)
	{
		return accounts.toString();
	}
	
	public String transactionsInfo(int id) {
		return transactions.toString();
	}
	
	public String completeUserInfo() {
		return null;			
	}

	public String getUserPassword() {
		return this.password;
	}

}
