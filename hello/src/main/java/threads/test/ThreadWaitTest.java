package threads.test;
class ThreadWaitTest{

	public static void main(String[] args) throws InterruptedException{
		final Object evt = new Object();
		Runnable r = new Runnable(){

			public void run(){
				for(int i = 1; i < 5001; i++)
					System.out.println("Hello : " + i + " from child thread");
				synchronized(evt){ // Current thread becomes owner of evt's monitor
					evt.notify();
					// Current thread notifies evt's monitor
				} // Current releases evt's monitor
			}
		};
		Thread t = new Thread(r); 
		t.start(); 
		for(int i = 1; i < 3001; i++)
			System.out.println("Welcome : " + i + " from main thread");
		synchronized(evt){ // Current thread becomes owner of evt
			evt.wait();
			// Step 1 : If current thread is not an owner of evt's monitor then throw IllegalMonitorStateException
			// Step 2 : Current thread releases evt's monitor
			// Step 3 : Requests JVM not to schedule current thread until evt's monitor is notified
			// Step 4 : Current thread reaquires evt's monitor
			// Step 5 : If current thread's interrupted flag has been set throw InterruptedException 
		} // Current thread releases evt's monitor
		System.out.println("**************** GOODBYE ****************");
	}
}








