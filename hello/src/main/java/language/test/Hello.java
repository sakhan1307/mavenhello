package language.test;
class Greeter{
	
	static{
		System.out.println("Greeter initialized");
	}
	
	public static void greet(String name){
		System.out.println("Hello " + name);
	}
}

class App{

	public static void main(String[] args){
		if(args.length > 0)
			Greeter.greet(args[0]);
		else
			System.out.println("Hello World!");
	}
}












