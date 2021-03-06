package collections.test;
import java.util.*;

import collections.payroll.*;

class TreeSetTest2{

	private static void populate(Collection<Employee> employees){
		Employee manager = new Employee(220, 350);
		employees.add(manager);
		employees.add(new Employee(195, 80));
		employees.add(new Employee(205, 95));
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
		Comparator<Employee> c = new Comparator<Employee>(){
			public int compare(Employee fe, Employee se){
				if(fe.getRate() != se.getRate())
					return (int) (se.getRate() - fe.getRate());
				return fe.getId() - se.getId();
			}
		};
		TreeSet<Employee> dept = new TreeSet<Employee>(c);
		populate(dept);
		process(dept);
	}
}




