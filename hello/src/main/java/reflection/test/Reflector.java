package reflection.test;

import java.lang.reflect.*;

class Reflector{

	private static void printFields(Object obj, Class<?> c){
		Class<?> sc = c.getSuperclass();
		if(sc != Object.class) printFields(obj, sc);
		Field[] fields = c.getDeclaredFields();
		for(int i = 0; i < fields.length; i++){
			int m = fields[i].getModifiers();
			if(Modifier.isStatic(m)) continue;
			System.out.print("    " + fields[i].getName() + " = ");
			try{
				fields[i].setAccessible(true); // Requires suppressAccessCheck ReflectPermission
				System.out.println(fields[i].get(obj));
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}

	private static void printObject(Object obj){
		Class<? extends Object> c = obj.getClass();
		System.out.println("Class : " + c.getName());
		printFields(obj, c);
	}

	public static void main(String[] args) throws Exception{
		printObject(new reflection.payroll.SalesPerson(210, 85, 60000));
	}
}