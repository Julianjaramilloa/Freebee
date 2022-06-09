package logic;

public class Account{
	int id;
	String name;
	float balance;
	String currency;
	
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
	
	protected int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Cuenta: " + name + "; " + balance + "; " + currency + "; ID: " + id;
	}
	

	
}
