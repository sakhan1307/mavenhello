package threads.test;
class PrintItem{

	private static ThreadLocal<String> slot = new ThreadLocal<String>();
	
	public static String getText(){
		return (String) slot.get();
	}

	public static void setText(String value){
		slot.set(value);
	}
}

class LoopPrinter{
	
	public static void print(int count){
		for(int i = 1; i <= count; i++)
			System.out.println(PrintItem.getText() + " : " + i + " from thread<" + Thread.currentThread().hashCode() + ">");
	}
}

class ThreadLocalTest{

	public static void main(String[] args){
		Runnable r = new Runnable(){
			public void run(){
				PrintItem.setText("Hello");
				LoopPrinter.print(2000);
			}
		};
		Thread t = new Thread(r);
		t.start();
		PrintItem.setText("Welcome");
		LoopPrinter.print(3000);
	}
}







