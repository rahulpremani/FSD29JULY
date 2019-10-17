package assignments1;

import java.util.Scanner;

public class SumOfNumbersDivisibleByThreeAndFive {

	static int calculateSum(int n) {
		
		int sum = 0;
		int count = 0;
		for(int i = 1; ; i+=2) {
			if(count == n) {
				break;
			}
			if(i%3 == 0 && i%5==0) {
				sum+=i;
				count++;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number : ");
		System.out.println(calculateSum(scan.nextInt()));
		scan.close();
	}

}
