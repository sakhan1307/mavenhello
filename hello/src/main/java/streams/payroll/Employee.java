package streams.payroll;

import java.io.*;

public class Employee implements Serializable{
	
	private int id;
	private int hours;
	private float rate;
	private transient String pwd;
	private static int count;
	static final long serialVersionUID = 5345581675626700682L;

	public Employee(int h, float r){
		id = 101 + count++;
		hours = h;
		rate = r;
	}
	
	public Employee(){
		this(0, 0);
	}	
	
	public final int getId(){
		return id;
	}

	public final int getHours(){
		return hours;
	}

	public final void setHours(int value){
		hours = value;
	}
	
	public final float getRate(){
		return rate;
	}

	public final void setRate(float value){
		rate = value;
	}

	public final void setPassword(String value){
		pwd = value;
	}

	public final boolean checkPassword(String value){
		return pwd.equals(value);
	}
	

	public double getNetIncome(){
		double income = hours * rate;
		int ot = hours - 180;
		if(ot > 0) income += 50 * ot;
		return income;
	}

	public static int countEmployees(){
		return count;
	}

	public String toString(){
		return id + "\t" + hours + "\t" + rate + "\t" + pwd;
	}

	public int hashCode(){
		return id;
	}
	
	public boolean equals(Object other){
		if(other instanceof Employee){
			Employee that = (Employee) other;
			return (this.id == that.id) && (this.hours == that.hours) && (this.rate == that.rate);
		}
		return false;
	}
	
	public void finalize(){
		System.out.println("Employee " + id + " object reclaimed");
	}

	public Employee(int i, int h, float r){
		this(h, r);
		id = i;
	}

	private void writeObject(ObjectOutputStream out) throws Exception{
		out.defaultWriteObject();
		byte[] data = pwd.getBytes();
		for(int i = 0; i < data.length; i++)
			data[i] = (byte) (data[i] + ' ');
		out.writeInt(data.length);
		out.write(data);
	}
	
	private void readObject(ObjectInputStream in) throws Exception{
		in.defaultReadObject();
		int n = in.readInt();
		byte[] data = new byte[n];
		in.read(data);
		for(int i = 0; i < data.length; i++)
			data[i] = (byte) (data[i] - ' ');
		pwd = new String(data);
	}
}
























