package language.test;
import language.payroll.*;

class PayrollTest2{

	private static double getAverageIncome(Employee[] employees){
		double total = 0;
		for(int i = 0; i < employees.length; i++){
			total += employees[i].getNetIncome();
		}
		return total / employees.length;
	}

	private static double getTotalSales(Employee[] employees){
		double total = 0;
		for(int i = 0; i < employees.length; i++){
			if(employees[i] instanceof SalesPerson){
				SalesPerson sp = (SalesPerson) employees[i];
				total += sp.getSales();
			}
		}
		return total;
	}

	public static void main(String[] args){
				
		Employee[] dept = {
			new Employee(190, 110),
			new Employee(225, 300),
			new SalesPerson(175, 65, 50000),
			new Employee(135, 95),
			new SalesPerson(160, 80, 70000)
		};
		
		System.out.println("Average income : " + getAverageIncome(dept));	
		System.out.println("Total sales : " + getTotalSales(dept));
	}
}





