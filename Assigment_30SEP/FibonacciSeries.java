import java.util.Scanner;

class FibonacciSeries {

	static void PrintFibonacci(int num, int a, int b) {

		if (b>num)
			return; 
		System.out.println(b);
		PrintFibonacci(num,b,a+b);

	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number upto which you want to print Fibonacci Series");
		int num = scan.nextInt();
		int a = 0;
		int b = 1;
		FibonacciSeries.PrintFibonacci(num,a,b);
	}
}