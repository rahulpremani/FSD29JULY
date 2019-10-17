package assignments1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizing {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the integers : ");
		String integers = scan.nextLine();
		
		StringTokenizer stringTokenize = new StringTokenizer(integers," ");
		
		int sum = 0;
		while(stringTokenize.hasMoreTokens() != false) {
			
			int temp = Integer.parseInt(stringTokenize.nextToken());
			System.out.println(temp);
			sum+=temp;
		}
		System.out.println("The sum of the integers you entered is : "+sum);
		
		scan.close();

	}

}
