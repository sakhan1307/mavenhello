package collections.test;
import java.util.*;

import collections.payroll.*;

class HashMapTest{

	private static void populate(Map<String, Employee> employees){
		employees.put("jack", new Employee(195, 115));
		employees.put("jill", new Employee(180, 250));
		employees.put("jim", new SalesPerson(160, 75, 30000));
		employees.put("john", new Employee(220, 95));
		employees.put("jane", new SalesPerson(185, 100, 75000));
		employees.put("jack", new Employee(225, 350));
	}

	public static void process(Map<String, Employee> employees){
		Set<Map.Entry<String, Employee>> pairs = employees.entrySet();
		for(Iterator<Map.Entry<String, Employee>> i = pairs.iterator(); i.hasNext();){
			Map.Entry<String, Employee> pair = (Map.Entry<String, Employee>) i.next();
			System.out.println(pair.getKey() + "\t" + pair.getValue());
		}

	}

	public static void main(String[] args){
		HashMap<String, Employee> dept = new HashMap<String, Employee>();
		populate(dept);
		if(args.length == 0)
			process(dept);
		else{
			Employee emp = dept.get(args[0]);
			if(emp != null)
				System.out.println(emp + "\t" + emp.getNetIncome());
		}
	}
}



