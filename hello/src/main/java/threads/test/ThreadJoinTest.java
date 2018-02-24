package threads.test;
class ThreadJoinTest{

	public static void main(String[] args) throws InterruptedException{

		Runnable r = new Runnable(){

			public void run(){
				for(int i = 1; i < 5001; i++)
					System.out.println("Hello : " + i + " from child thread");
			}
		};
		Thread t = new Thread(r); 
		t.start(); 
		for(int i = 1; i < 3001; i++)
			System.out.println("Welcome : " + i + " from main thread");
		t.join();
		// step 1 : Requests JVM not to schedule current thread until t terminates.
		// step 2 : If current thread's interrupted flag has been set then clear this flag and throw InterruptedException
		System.out.println("**************** GOODBYE ****************");
	}
}








