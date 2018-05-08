package annotation.test;

class BoxingTest{

	public static void main(String[] args){
		long l = 12345678;
		Object ol = l; //new Long(l);
		System.out.println(ol);
		Double d = 2.303; //new Double(2.303);
		d *= 1.7; //d = new Double(d.doubleValue() * 1.7);
		System.out.println(d);
	}
}
