package annotation.test;

import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.TYPE)
@interface ReducingBalance{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DurationLimit{
	int value(); //upper
	int lower() default 1;
}

@ReducingBalance
class EducationLoan{

	public float interestRate(double amount, int period){
		return 7.5f;
	}
}

class PersonalLoan{

	@DurationLimit(4)
	public float interestRate(double amount, int period){
		return (amount < 50000) ? 9.5f : 10.5f;
	}
}

@ReducingBalance
class HomeLoan{

	@DurationLimit(value=8, lower=3)
	public float interestRate(double amount, int period){
		return (period < 5) ? 8.5f : 10.0f;
	}
}

class CarLoan extends HomeLoan{}

class AnnotationTest{

	private static double installment(double p, int n, float r, boolean reducing){
		int m = 12 * n;
		if(reducing){
			float i = r / 1200;
			return p * i / (1 - Math.pow(1 + i, -m));
		}

		return p * Math.pow(1 + r / 100, n) / m;
	}

	public static void main(String[] args) throws Exception{
		double p = Double.parseDouble(args[0]);
		Class<?> c = Class.forName(args[1]);
		boolean rb = c.isAnnotationPresent(ReducingBalance.class);
		Method meth = c.getMethod("interestRate", double.class, int.class);
		DurationLimit dl = meth.getAnnotation(DurationLimit.class);
		int l = (dl == null) ? 1 : dl.lower();
		int u = (dl == null) ? 10 : dl.value();
		if(rb) System.out.println("Using reducing-balance method");
		Object scheme = c.newInstance();
		for(int n = l; n <= u; n++){
			Float r = (Float) meth.invoke(scheme, p, n);
			double emi = installment(p, n, r.floatValue(), rb);
			System.out.printf("%d\t%.2f%n", n, emi);
		}		
	}
}














