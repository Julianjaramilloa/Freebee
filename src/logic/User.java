package logic;

import java.time.LocalDate;

import seqDataStructures.DynamicArray;
import seqDataStructures.DynamicArrayIterator;
import seqDataStructures.LinkedList;
import seqDataStructures.LinkedListIterator;

//Esta clase es el alma de la aplicación.
public class User {
	private String userName;
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
		this.userName = userName;
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
	
	public String getUserName() {
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
