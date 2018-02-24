package threads.test;
class ThreadSleepTest{

	public static void main(String[] args){

		Runnable r = new Runnable(){

			public void run(){
				for(int i = 1; i < 3001; i++)
					System.out.println("Hello : " + i + " from child thread");
				try{
					Thread.sleep(5000); 
					// step 1 : Requests JVM not to schedule current thread for next 5000 ms
					// step 2 : If current thread's interrupted flag has been set then reset the flag and throw InterruptedException
				}catch(InterruptedException e){
					System.out.println("Sleep interrupted!");
				}

				System.out.println("************************* GOODBYE *************************");
			}
		};
		Thread t = new Thread(r); 			  
		t.start(); 
		for(int i = 1; i < 5001; i++)
			System.out.println("Welcome : " + i + " from main thread");
		t.interrupt(); // Sets thread t's interrupted flag and requests JVM to schedule t
	}
}









