package language.test;
import language.edu.met.iit.banking.*;

class BankingTest3{

	private static void payAnnualInterest(Account[] accounts){
		for(int i = 0; i < accounts.length; i++){
			if(accounts[i] instanceof Profitable){
				Profitable p = (Profitable) accounts[i];
				p.addInterest(1, 6);
			}

		}
	}

	public static void main(String[] args){
		Banker b = Banker.getBanker();
		Account[] bank = new Account[4];
		bank[0] = b.openAccount(9500, true);
		bank[1] = b.openAccount(10000, false);
		bank[2] = b.openAccount(10000, false);
		bank[3] = b.openAccount(9500, true);
		payAnnualInterest(bank);
		for(int i = 0; i < 4; i++)
			System.out.println(bank[i].getId() + "\t" + bank[i].getBalance());
	}
}