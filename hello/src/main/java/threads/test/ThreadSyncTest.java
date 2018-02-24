package threads.test;
class JointAccount{

	private int balance = 5000;
	
	public int getBalance(){
		return balance;
	}

	public synchronized boolean deposit(int amount){
		balance += amount;
		return true;
	}
	
	public boolean withdraw(int amount){
		boolean result = false;
		// A thread can enter a synchronized block only if it owns 
		// target object's monitor. If object's monitor is free then 
		// current thread becomes owner of object's monitor and enters
		// synchronized block. If some other thread owns object's monitor 
		// then current thread is blocked until monitor becomes available. 
		synchronized(this){
			if(balance >= amount){
				try{
					Thread.sleep(amount / 100);
				}catch(InterruptedException e){}
				balance -= amount;
				result = true;
			}
		} // Current thread releases target object's monitor
		return result;
	}	
}

class ThreadSyncTest{

	public static void main(String[] args) throws InterruptedException{
		final JointAccount acc = new JointAccount();
		System.out.println("JointAccount opened for Jack and Jill");
		System.out.println("Initial balance : " + acc.getBalance());
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("Jill withdraws 4000");
				if(!acc.withdraw(4000))
					System.out.println("Jill's withdrawal failed");
			}
		};
		Thread t = new Thread(r);
		t.start();
		System.out.println("Jack withdraws 3000");
		if(!acc.withdraw(3000))
			System.out.println("Jack's withdrawal failed");
		t.join();
		System.out.println("Final balance : " + acc.getBalance());
		
	}
}










