package language.test;
interface Filter{
	boolean allowed(int value);
}

class Printer{

	public static void printAll(int[] values){
		for(int i = 0; i < values.length; i++){
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}

	public static void printIf(int[] values, Filter check){
		for(int i = 0; i < values.length; i++){
			if(check.allowed(values[i]))
				System.out.print(values[i] + " ");
		}
		System.out.println();
	}
}

class CallbackTest{
	
	// Nested member class
	static class IsOdd implements Filter{
		
		public boolean allowed(int value){
			return (value & 1) == 1;
		}
	}

	// Inner member class
	class IsEven implements Filter{
	
		public boolean allowed(int value){
			return (value & 1) == 0;
		}
	}

	public static void main(final String[] args){
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.print("All : ");
		Printer.printAll(numbers);
		Filter a = new CallbackTest.IsOdd();
		System.out.print("Odd : ");
		Printer.printIf(numbers, a);
		CallbackTest cbt = new CallbackTest();
		Filter b = cbt.new IsEven();
		System.out.print("Even : ");
		Printer.printIf(numbers, b);
		final int limit = 5;
		Filter c = new Filter(){
			{
				// System.out.println("-- Anonymous Filter instantiated");
			}
			public boolean allowed(int value){
				return (value < limit);
			}
		};
		System.out.print("Small : ");
		Printer.printIf(numbers, c);
	}
}









