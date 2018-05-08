package reflection.test;

//import reflection.finance.*;
import java.text.*;
import java.lang.reflect.*;

class LateBindingTest{

	public static void main(String[] args) throws Exception{
		double p = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		Class<?> c = Class.forName(args[2]);
		String methodName = args[3];
		Object pol = c.newInstance();
		Class<?>[] signature = {double.class, int.class};
		Method meth = c.getMethod(methodName, signature);
		Object[] arguments = {new Double(p), new Integer(n)};
		Float result = (Float) meth.invoke(pol, arguments);
		float i = result.floatValue() / 1200;
		int m = 12 * n;
		double e = p * i / Math.pow(1 + i, -m);
		DecimalFormat formatter = new DecimalFormat("0.00");
		System.out.println("E.M.I : " + formatter.format(e));
	}
}





