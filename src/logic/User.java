package logic;

import java.time.LocalDate;

import seqDataStructures.DynamicArray;
import seqDataStructures.DynamicArrayIterator;
import seqDataStructures.LinkedList;
import seqDataStructures.LinkedListIterator;

//Esta clase es el alma de la aplicación.
public class User {
	private String username;
	private String password;
	private DynamicArray<Account> accounts = new DynamicArray<Account>(); 
	private LinkedList<Transaction> transactions = new LinkedList<Transaction>();
	@SuppressWarnings("unused")
	private IncomingTransactions inc;//Implementación a futuro
	private short idProvider = 0;
	
	public DynamicArray<Account> getAccounts() {
		return this.accounts;
	}
	
	public LinkedList<Transaction> getTransactions() {
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
			short accId,
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
		transactions.pushBack(trans); //Toca hacer una verificación de si la cuenta existe
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
	
	public void setBalance(short id) {
		
	}
	
	public String accountsInfo(short id)
	{
		Account display = null;
		DynamicArrayIterator<Account> it = new DynamicArrayIterator<Account>(accounts);
		Account aux;
		while(it.hasNext()) {
			aux = it.next();
			if(aux.id(id)) {
				display=aux;
				break;
			}
		}
		if(display != null) {
			return display.toString();
		}else {
			return "La cuenta no existe(Corregir error)";
		}
	}
	
	public void transactionsInfo(short id) {
		System.out.println("Transacciones de la cuenta:");
		LinkedListIterator<Transaction> it = new LinkedListIterator<Transaction>(transactions);
		Transaction aux;
		while(it.hasNext()) {
			aux = it.next();
			if(aux.id(id)) {
				System.out.println(aux.toString());
			}
		}
	}
	
	public String completeUserInfo() {
		return null;			
	}

	public String getUserPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

}
