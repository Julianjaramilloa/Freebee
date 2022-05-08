package logic;

public class Account{
	short id;
	String name;
	float balance;
	float currency;
	
	public Account(
			short id,
			String name,
			float balance,
			float currency) 
	{
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.currency = currency;
	}
}
