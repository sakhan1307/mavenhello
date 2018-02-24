package streams.test;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

class NewIOTest{

	private static void reverse(ByteBuffer bytes){
		int i = 0;
		int j = bytes.capacity() - 1;
		while(i < j){
			byte ib = bytes.get(i);
			byte jb = bytes.get(j);
			bytes.put(i++, jb);
			bytes.put(j--, ib);
		}
	}

	public static void main(String[] args) throws Exception{
		RandomAccessFile file = new RandomAccessFile(args[0], "rw");
		FileChannel channel = file.getChannel();
		FileLock lock = channel.lock();
		MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
		reverse(buffer);
		lock.release();
		channel.close();
		file.close();
	}
}