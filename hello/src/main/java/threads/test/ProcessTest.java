package threads.test;
class ProcessTest{

	public static void main(String[] args) throws Exception{
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec("notepad");
		for(int i = 10; i > 0; i--){
			Thread.sleep(1000);
			System.out.println(i);
		}
		// p.waitFor();
		p.destroy();
		System.out.println("Goodbye!");
	}
}