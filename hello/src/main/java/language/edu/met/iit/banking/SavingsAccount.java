package language.edu.met.iit.banking;

public final class SavingsAccount extends BankAccount implements Profitable{

	public static final double MINIMUM_BALANCE = 500.0;

	public SavingsAccount(){
		id = "S/A";
		balance = MINIMUM_BALANCE;
	}
	
	public void withdraw(double amount) throws InsufficientFundsException{
		if(balance - amount < MINIMUM_BALANCE)
			throw new InsufficientFundsException();
		balance -= amount;
	}

	public double addInterest(int period, float rate){
		double interest = balance * period * rate / 100;
		balance += interest;
		return interest;
	}
}







