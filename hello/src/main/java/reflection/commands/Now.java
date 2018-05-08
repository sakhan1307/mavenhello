package reflection.commands;

public class Now implements Runnable{

	public void run(){
		System.out.println(new java.util.Date());
	}
}

