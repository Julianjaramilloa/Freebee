package logic;

public class Account{
	private int id;
	private String name;
	private float balance;
	private String currency;
	
	public Account(
			int id,
			String name,
			float balance,
			String currency) 
	{
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.currency = currency;
	}
	
	protected void updateBalance(float transaction, boolean t) {
		if(t == true) {
			this.balance = this.balance + transaction;
		}else{
			this.balance = this.balance - transaction;
		}
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getBalance() {
		return this.balance;
	}
	
	@Override
	public String toString() {
		return name + "; " + balance + "; " + currency + "; ID: " + id;
	}
	
	public String saveData() {
		return name + ";" + currency + ";" + currency;
	}
	
}
