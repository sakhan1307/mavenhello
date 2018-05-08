package reflection.test;

import reflection.finance.*;
import java.text.*;

class DynamicBindingTest{

	public static void main(String[] args) throws Exception{
		double p = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		Class<?> c = Class.forName(args[2]);
		LoanPolicy pol = (LoanPolicy) c.newInstance();
		float r = pol.interestRate(p, n);
		float i = r / 1200;
		int m = 12 * n;
		double e = p * i / Math.pow(1 + i, -m);
		DecimalFormat formatter = new DecimalFormat("0.00");
		System.out.println("E.M.I : " + formatter.format(e));
	}
}