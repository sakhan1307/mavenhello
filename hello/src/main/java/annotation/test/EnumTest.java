package annotation.test;

import java.util.*;

enum RoomTypeD{
	ECONOMY, BUSINESS, EXECUTIVE, DELUXE;
}

class EnumTest{

	private static Scanner scan;

	private static double totalRent(int days, RoomTypeD rt){
		double rate;
		switch(rt){
			case ECONOMY:
				rate = 245.0;
				break;

			case BUSINESS:
				rate = 360.0;
				break;

			case EXECUTIVE:
				rate = 485.0;
				break;

			default:
				rate = 655.0;
		}
		return days * rate;
	}

	public static void main(String[] args){
		scan = new Scanner(System.in);
		System.out.printf("Enter number of days : ");
		int n = scan.nextInt();
		System.out.printf("Total rent for economy room will be %.2f%n", totalRent(n, RoomTypeD.ECONOMY));
		System.out.printf("Total rent for deluxe room will be %.2f%n", totalRent(n, RoomTypeD.DELUXE));
	}
}











