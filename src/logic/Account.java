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
	
	protected void updateBalance(float transaction) {
		if(balance < 0) {
			this.balance = this.balance - transaction;
		}else {
			this.balance = this.balance + transaction;
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
		return "Cuenta: " + name + "; " + balance + "; " + currency + "; ID: " + id;
	}
	

	
}
