package logic;

public class Account{
	short id;
	String name;
	float balance;
	String currency;
	
	public Account(
			short id,
			String name,
			float balance,
			String currency) 
	{
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.currency = currency;
	}
	
	public String accountInfo() {
		return this.name + "; " + this.balance + "; " + this.currency;
	}
	
}
