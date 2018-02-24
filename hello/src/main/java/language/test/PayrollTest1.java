package language.test;
import language.payroll.Employee;
import language.payroll.SalesPerson;

class PayrollTest1{

	private static double getIncomeTax(Employee emp){
		double i = emp.getNetIncome();
		return (i < 10000) ? 0 : 0.15 * i;	
	}

	public static void main(String[] args){
		
		Employee jack = new Employee();
		jack.setHours(170);
		jack.setRate(55);
		SalesPerson jill = new SalesPerson(170, 55, 80000);
		System.out.println("Jack's ID is " + jack.getId() + ", Income is " + jack.getNetIncome() + " and Tax is " + getIncomeTax(jack));
		System.out.println("Jill's ID is " + jill.getId() + ", Income is " + jill.getNetIncome() + " and Tax is " + getIncomeTax(jill));
		System.out.println("Number of employees : " + Employee.countEmployees());
	}
}






