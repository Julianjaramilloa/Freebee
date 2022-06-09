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
	
	protected void setBalance(float balance) {
		this.balance = balance;
	}
	
	protected boolean id(int id) {
		if (this.id == id) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Cuenta: " + name + "; " + balance + "; " + currency + "; ID: " + id;
	}
	

	
}
