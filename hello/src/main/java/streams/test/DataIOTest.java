package streams.test;
import java.io.*;

class DataIOTest{
	
	public static void main(String[] args) throws Exception{
		String file = "product.dat";
		if(args.length > 2){
			String item = args[0];
			short stock = Short.parseShort(args[1]);
			float cost = Float.parseFloat(args[2]);
			DataOutputStream out = new DataOutputStream(
					new FileOutputStream(file));
			out.writeUTF(item);
			out.writeShort(stock);
			out.writeFloat(cost);
			out.close();
		}else{
			DataInputStream in = new DataInputStream(
					new FileInputStream(file));
			String item = in.readUTF();
			short stock = in.readShort();
			float cost = in.readFloat();
			in.close();
			System.out.println(item + "\t" + stock + "\t" + cost);
		}
	}
}









