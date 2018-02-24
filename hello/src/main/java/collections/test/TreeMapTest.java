package collections.test;
import java.util.*;

import collections.payroll.*;

class TreeMapTest{

	private static void populate(Map employees){
		employees.put("jack", new Employee(195, 115));
		employees.put("jill", new Employee(180, 250));
		employees.put("jim", new SalesPerson(160, 75, 30000));
		employees.put("john", new Employee(220, 95));
		employees.put("jane", new SalesPerson(185, 100, 75000));
		employees.put("jack", new Employee(225, 350));
	}

	public static void process(Map employees){
		Set pairs = employees.entrySet();
		for(Iterator i = pairs.iterator(); i.hasNext();){
			Map.Entry pair = (Map.Entry) i.next();
			System.out.println(pair.getKey() + "\t" + pair.getValue());
		}

	}

	public static void main(String[] args){
		TreeMap dept = new TreeMap();
		populate(dept);
		if(args.length == 0)
			process(dept);
		else{
			Employee emp = (Employee) dept.get(args[0]);
			if(emp != null)
				System.out.println(emp + "\t" + emp.getNetIncome());
		}
	}
}



