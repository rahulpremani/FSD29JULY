package assignments1;

import java.util.Scanner;

public class PowerOfTwo {

	static boolean checkNumber(int number) {
		
		int pow = 1;
		while(pow<number) {
			pow*=2;
		}
		return (pow==number);
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number :");
		System.out.println(PowerOfTwo.checkNumber(scan.nextInt()));
		scan.close();
	}

}
