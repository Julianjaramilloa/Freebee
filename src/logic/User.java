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
	private IncomingTransactions incomingTransactions = new IncomingTransactions();
	private int idAccountProvider = 1; //Asigna automáticamente un id a la cuenta que se vaya a incluir
	private int idTransactionProvider = 1; //Asigna automáticamente un id a la transacción que se vaya a incluir
	
	public User(String userName, String password) {
		this.username = userName;
		this.password = password;
	};
	
	public String addAccount(String name, float balance, String currency) {
		int id = idAccountProvider;
		Account acc = new Account(id, name, balance, currency);
		accounts.pushBack(acc);
		String returnMessage = "Cuenta creada con el id " + idAccountProvider; 
		idAccountProvider ++;
		return returnMessage;
	}
	
	public DynamicArray<Account> getAccounts() {
		return this.accounts;
	}
	
	public void addTransactionData(
			LocalDate date,
			int accId,
			String desc,
			TransactionCategory type, 
			float amount,
			boolean isIngreso) {
		int idTransaction = idTransactionProvider;
		Transaction trans = new Transaction(
				date,
				accId,
				idTransaction,
				desc,
				type,
				amount,
				isIngreso);
		addTransaction(trans);
	}
	
	public void addTransaction(Transaction transaction) {
		try{
			transactions.insertNode(transaction); 
		}catch(IllegalArgumentException iae) {
			System.err.println("La transacción ya existe");
		}
		setBalance(transaction.accountId(), transaction.amount());
		idTransactionProvider ++;
		
	}
	
	public AVLTree<Transaction> getTransactions() {
		return this.transactions;
	}
	
	public void addIncomingTransaction(
			LocalDate date,
			int accId,
			String desc,
			TransactionCategory type, 
			float amount,
			boolean isIngreso) {
		Transaction incomingTransaction = new Transaction(date, accId, idTransactionProvider, desc, type, amount, isIngreso);
			incomingTransactions.addIncomingTransaction(incomingTransaction);
		idTransactionProvider ++;
	}
	
	protected void incorporateIncomingTransactions() {
		LinkedList<Transaction> incoming = this.incomingTransactions.popTransaction();
		LinkedListIterator<Transaction> it = new LinkedListIterator<Transaction>(incoming);
		
		while(it.hasNext()) {
			Transaction ts = it.next();
			try{
				this.transactions.insertNode(ts);
			}catch (IllegalArgumentException iae) {
				System.err.println("Una transacción que estaba programada para ser incorporada ya existe actualmente: \n"
						+ ts.toString() +" \nNo se hizo la inserción");
			}
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
	
	private void setBalance(int accountId, float change) {
		DynamicArrayIterator<Account> it = new DynamicArrayIterator<Account>(this.accounts);
		Account toChange = null;
		while(it.hasNext()) {
			Account ac = it.next();
			if(ac.id == accountId) {
				toChange = ac;
			}
		}
		toChange.updateBalance(change);
	}
	
	public String accountsInfo(int id)
	{
		return accounts.toString();
	}
	
	public String transactionsInfo(int id) {
		return transactions.toString();
	}
	
	public String completeUserInfo() {
		String completeUserInfo = "                                Info Completa del Usuario: \n";
		String userStats = "Username: " + username +"; #Cuentas: " + accounts.size() + "; #Transacciones: " + transactions.size() + '\n';
		completeUserInfo += userStats;
		completeUserInfo += accounts.verticalOrder();
		completeUserInfo += '\n';
		completeUserInfo += transactions.preorderTraverse();
		
		return completeUserInfo; 			
	}

}
