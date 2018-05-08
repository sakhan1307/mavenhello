package annotation.test;

import java.util.*;

enum RoomTypeR{
	ECONOMY(245.0), BUSINESS(360.0), EXECUTIVE(485.0), DELUXE(655.0);
	
	private double rate;

	private RoomTypeR(double value){
		rate = value;
	}

	public double rent(){
		return rate;
	}
}

class EnumDataTest{

	private static Scanner scan;

	private static double totalRent(int days, RoomTypeR rt){
		return days * rt.rent();
	}

	public static void main(String[] args){
		scan = new Scanner(System.in);
		System.out.printf("Enter number of days : ");
		int n = scan.nextInt();
		System.out.printf("Total rent for economy room will be %.2f%n", totalRent(n, RoomTypeR.ECONOMY));
		System.out.printf("Total rent for deluxe room will be %.2f%n", totalRent(n, RoomTypeR.DELUXE));
	}
}











