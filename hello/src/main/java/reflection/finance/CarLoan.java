package reflection.finance;

public class CarLoan implements LoanPolicy{

	public final float interestRate(double amount, int duration){
		return (amount < 500000) ? 9.0f : 10.0f;
	}
}