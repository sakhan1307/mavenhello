package language.edu.met.iit.banking;

public interface Profitable{
	
	/**
	Adds interest to this account.
	@param period duration in years
	@param rate interest rate in percent per annum.
	@return The added interest
	*/
	double addInterest(int period, float rate);
	double DEFAULT_RATE = 6.0;
}