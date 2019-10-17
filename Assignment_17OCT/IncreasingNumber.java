package assignments1;

import java.util.Scanner;

public class IncreasingNumber {

	static boolean checkIncreasingNumber(int number) {
		
		String str = Integer.toString(number);
		for(int i = 0; i <str.length()-1; i++) {
			if((str.charAt(i)<=str.charAt(i+1)) == false) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number to be checked :");
		System.out.println(IncreasingNumber.checkIncreasingNumber(scan.nextInt()));
		scan.close();
	}

}
