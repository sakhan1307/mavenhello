package annotation.test;

import java.util.*;

enum RoomType{
	ECONOMY{
		public double rent(boolean hs){
			return hs ? 260.0 : 245.0;
		}
	}, 
	
	BUSINESS{
		public double rent(boolean hs){
			return 360.0;
		}
	}, 

	EXECUTIVE{
		public double rent(boolean hs){
			return 485.0;
		}
	}, 

	DELUXE{
		public double rent(boolean hs){
			return hs ? 710.0 : 655.0;
		}
	};

	public abstract double rent(boolean holidaySeason);

	public String toString(){
		return name().toLowerCase();
	}
}

class EnumCodeTest{

	private static Scanner scan;

	public static void main(String[] args){
		scan = new Scanner(System.in);
		System.out.printf("Enter number of days : ");
		int n = scan.nextInt();
		System.out.printf("Holiday season (y/n) : ");
		String h = scan.next();
		boolean b = h.toLowerCase().equals("y");
		for(RoomType rt : RoomType.values())
			System.out.printf("Total rent for %s room will be %.2f%n", rt, n * rt.rent(b));
	}
}











