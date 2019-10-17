package assignments1;

import java.util.Scanner;

public class DifferenceBetweenSums {

	static int calculateDifference(int n) {
		
		int sumOfSquares = 0 ;
		int squareOfSum = 0;
		
		for(int i = 0; i <= n; i++) {
			sumOfSquares+= i*i;
			squareOfSum+=i;
		}
		squareOfSum*=squareOfSum;
		return sumOfSquares-squareOfSum;
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number :");
		System.out.println(DifferenceBetweenSums.calculateDifference(scan.nextInt()));
		scan.close();
	}

}
