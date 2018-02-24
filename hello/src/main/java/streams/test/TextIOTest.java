package streams.test;
import java.io.*;

class TextIOTest{
	
	public static void main(String[] args) throws Exception{
		String file = "product.txt";
		if(args.length > 2){
			String item = args[0];
			short stock = Short.parseShort(args[1]);
			float cost = Float.parseFloat(args[2]);
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
					new FileOutputStream(file)));
			out.println(item);
			out.println(stock);
			out.println(cost);
			out.close();
		}else{
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
					new FileInputStream(file)));
			String item = in.readLine();
			short stock = Short.parseShort(in.readLine());
			float cost = Float.parseFloat(in.readLine());
			in.close();
			System.out.println(item + "\t" + stock + "\t" + cost);
			BufferedReader console = new BufferedReader(
					new InputStreamReader(System.in));
			System.out.print("Enter your name : ");
			String name = console.readLine();
			System.out.println("Goodbye " + name);
		}
	}
}









