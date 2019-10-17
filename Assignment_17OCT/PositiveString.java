package assignments1;

import java.util.Scanner;

public class PositiveString {

	static boolean positiveStringChecker(String str) {
	
		str = str.toUpperCase();
		for(int i = 0; i< str.length()-1; i++) {
			if((str.charAt(i)<str.charAt(i+1)) == false) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the string to be checked");
		String str = scan.nextLine();
		
		System.out.println(positiveStringChecker(str));
		
		scan.close();
	}

}
