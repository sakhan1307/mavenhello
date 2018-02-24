package threads.test;
class ThreadTest2{

	public static void main(String[] args){

		Runnable r = new Runnable(){

			public void run(){
				for(int i = 1; i < 5001; i++)
					System.out.println("Hello : " + i + " from child thread");
			}
		};
		Thread t = new Thread(r); // Requests JVM to create a new thread which should 
					  // execute r.run() when it is scheduled
		t.setDaemon(true); // Converts thread t to background thread
		t.start(); // Requests JVM to start scheduling thread t
		for(int i = 1; i < 3001; i++)
			System.out.println("Welcome : " + i + " from main thread");
	}
}