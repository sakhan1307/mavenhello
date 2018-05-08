package reflection.commands;

import java.util.*;

public class Game implements Runnable{

	public void run(){
		Random rnd = new Random();
		int val = 1 + rnd.nextInt(6);
		System.out.println("Value : " + val);
	}
}
