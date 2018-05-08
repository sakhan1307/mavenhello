package annotation.test;

class VarArgsTest{

	private static double average(double first, double second, double... remaining){
		double total = first + second;
		int count = 2 + remaining.length;
		for(double value : remaining)
			total += value;
		return total / count;
	}

	public static void main(String[] args){
		double avg = average(17.3, 19.7, 14.8, 15.4, 16.5, 18.1);
			   //average(17.3, 19.7, new double[]{14.8, 15.4, 16.5, 18.1});
		System.out.printf("Average = %.2f%n", avg);		
	}
}
