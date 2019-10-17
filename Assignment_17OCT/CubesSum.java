package assignments1;

import java.util.Scanner;

public class CubesSum {

	static int calculateCubesSum(int number) {
		int sum = 0;
		while(number != 0) {
			int temp = number % 10;
			sum+=temp*temp*temp;
			number/=10;
		}
		return sum;
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number : ");
		
		System.out.println(CubesSum.calculateCubesSum(scan.nextInt()));
		
		scan.close();

	}

}
