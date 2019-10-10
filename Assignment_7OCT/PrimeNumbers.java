import java.util.Scanner;

class PrimeNumbers {

	static void PrintPrimeNumbers(int num) {

		if(num == 2) {
			System.out.println(2);
		}
		else if(num>2) {
			for(int i = 3; i <= num; i+=2) {
				int count = 0;
				for(int j = 3; j <= i; j+=2) {
					if(i % j == 0 ) {
						count++;
					}
				}
				if(count == 1) {
					System.out.println(i);
				}
			}
		}
		else {
			System.out.println("These values aren't permissible");
		}
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);	
		System.out.println("Enter the number upto which you wanna print the prime numbers");
		int limit = scan.nextInt();
		PrimeNumbers.PrintPrimeNumbers(limit);
	}
}