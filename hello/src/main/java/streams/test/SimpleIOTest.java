package streams.test;
import java.io.*;

class SimpleIOTest{

	private static void encrypt(InputStream in, OutputStream out, String key) throws IOException{
		byte[] buffer = new byte[key.length()];
		while(in.available() > 0){
			int n = in.read(buffer, 0, buffer.length);
			for(int i = 0; i < n; i++)
				buffer[i] = (byte) (buffer[i] ^ key.charAt(i));
			out.write(buffer, 0, n);
		}
	}
	
	public static void main(String[] args){
		try{
			FileInputStream fin = new FileInputStream(args[0]);
			System.out.println("-- Opened " + args[0] + " for reading");
			FileOutputStream fout = new FileOutputStream(args[1]);
			System.out.println("-- Opened " + args[1] + " for writing");
			encrypt(fin, fout, args[2]);
			fout.close();
			fin.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}