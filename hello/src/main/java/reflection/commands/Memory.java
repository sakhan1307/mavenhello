package reflection.commands;

public class Memory implements Runnable{

	public void run(){
		Runtime jvm = Runtime.getRuntime();
		System.gc();
		System.out.println("Available : " + jvm.freeMemory() + "/" + jvm.totalMemory());
	}
}

