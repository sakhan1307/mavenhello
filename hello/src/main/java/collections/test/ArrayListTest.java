package collections.test;
import java.util.*;

import collections.payroll.*;

class ArrayListTest{

	private static void populate(Collection<Employee> employees){
		Employee manager = new Employee(220, 350);
		employees.add(manager);
		employees.add(new Employee(195, 80));
		employees.add(new Employee(200, 95));
		employees.add(new SalesPerson(160, 55, 30000));
		employees.add(new Employee(220, 200));
		employees.add(new SalesPerson(205, 75, 50000));
		employees.add(manager);	
	}

	private static void process(Collection<Employee> employees){
		Iterator<Employee> i = employees.iterator();
		while(i.hasNext()){
			Employee emp = (Employee) i.next();
			System.out.println(emp + "\t" + emp.getNetIncome());
		}
	}

	public static void main(String[] args){
		ArrayList<Employee> dept = new ArrayList<Employee>();
		populate(dept);
		process(dept);
		int n = dept.size();
		Employee m = (Employee) dept.get(n / 2); // O(1)
		System.out.println("ID of middle employee : " + m.getId());
	}
}




