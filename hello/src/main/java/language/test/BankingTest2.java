package language.test;
import language.edu.met.iit.banking.*;

class BankingTest2{

	public static void main(String[] args) throws InsufficientFundsException{
		Banker b = Banker.getBanker();
		Account cust = b.openAccount(4500, true);
		Account vend = b.openAccount(0, false);
		try{
			double amt = Double.parseDouble(args[0]); // new Double(args[0]).doubleValue();
			cust.transfer(amt, vend);
		}finally{
			System.out.println("Customer Account ID is " + cust.getId() + " and Balance is " + cust.getBalance());
		}
		System.out.println("Vendor Account ID is " + vend.getId() + " and Balance is " + vend.getBalance());		
	}
}



