package reflection.finance;

public interface LoanPolicy{

	float interestRate(double amount, int duration);
}