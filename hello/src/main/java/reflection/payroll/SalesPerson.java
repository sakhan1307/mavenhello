package reflection.payroll;

public class SalesPerson extends Employee{
	
	private double sales;
	private float commission = 0.05f;
	
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
	
	public final float getCommission(){
		return commission;
	}

	public final void setCommission(float value){
		commission = value;
	}


	public double getNetIncome(){
		double income = super.getNetIncome();
		income += commission * sales;
		return income;
	}
}










