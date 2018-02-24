package threads.test;
class ShutdownTest{

	public static void main(String[] args) throws Exception{
		Runtime rt = Runtime.getRuntime();
		Thread sht = new Thread(){
			public void run(){
				System.out.println("Done!");	
			}
		};
		rt.addShutdownHook(sht);
		System.out.println("Processing, please wait...");
		Thread.sleep(15000);
	}
}