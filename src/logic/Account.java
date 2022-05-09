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
	
	protected void setBalance(float balance) {
		this.balance = balance;
	}
	
	protected boolean id(short id) {
		if (this.id == id) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "idCuenta: " + id + " " + name + ", balance: " + balance + ", " + currency;
	}
	
}
