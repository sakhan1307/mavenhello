package language.test;
import language.payroll.*;

class PayrollTest3{

	public static void main(String[] args){
	
		Employee emp1 = new Employee(165, 75);
		Employee emp2 = new Employee(102, 165, 75);
		System.out.println("Hashcode of emp1 : " + emp1.hashCode());
		System.out.println("Hashcode of emp2 : " + emp2.hashCode());
		System.out.println("emp1 : " + emp1);
		System.out.println("emp2 : " + emp2);
		System.out.println("Identity Hashcode of emp1 : " + System.identityHashCode(emp1));
		System.out.println("Identity Hashcode of emp2 : " + System.identityHashCode(emp2));
		System.out.println("emp1 == emp2 : " + (emp1 == emp2));
		System.out.println("emp1.equals(emp2) : " + emp1.equals(emp2));
		emp2 = null;
		System.gc();
	}
}





