import java.util.Scanner;

class FibonacciSeries {

	static void PrintFibonacciRecursively(int num, int a, int b, int value) {

		if (value == num)
			return; 
		System.out.println(b);
		PrintFibonacciRecursively(num,b,a+b,++value);

	}
	
	static void PrintFibonacciNonRecursively(int num) {

		int a = 0, b = 1;
		int c = 0;
		int count = 0;
		while(count != num) {

			c = a + b;
			System.out.println(b);
			a = b;
			b = c;
			count++;
		}

	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number upto which you want to print Fibonacci Series");
		int num = scan.nextInt();
		int a = 0;
		int b = 1;
		FibonacciSeries.PrintFibonacciRecursively(num,a,b,0);
		FibonacciSeries.PrintFibonacciNonRecursively(num);
	}
}