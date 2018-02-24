package language.payroll;

public class SalesPerson extends Employee{
	
	private double sales;
	
	public SalesPerson(int h, float r, double s){
		super(h, r);
		sales = s;
	}

	public final double getSales(){
		return sales;
	}

	public final void setSales(double value){
		sales = value;
	}

	public double getNetIncome(){
		double income = super.getNetIncome();
		income += 0.05 * sales;
		return income;
	}
}










