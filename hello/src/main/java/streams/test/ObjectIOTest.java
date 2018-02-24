package streams.test;
import java.io.*;

import streams.payroll.*;

class ObjectIOTest{

	public static void main(String[] args) throws Exception{
		File file = new File("manager.ser");
		Employee manager;
		if(file.exists()){
			ObjectInputStream in = new ObjectInputStream(
						new FileInputStream(file));
			manager = (Employee) in.readObject();
			in.close();
		}else{
			manager = new Employee(225, 350);
			manager.setPassword("trustn01");
			ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(file));
			out.writeObject(manager);
			out.close();
		}
		System.out.println(manager);
	}
}







