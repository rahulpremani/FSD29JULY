import java.util.Scanner;

class CalculateFactorial {

	static int calcFactorial(int num)
	{
		if(num==1)
			return 1;
		else
			return num*calcFactorial(num-1); 
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number please");
		int factNumber = scan.nextInt();

		System.out.println("The factorial is " + CalculateFactorial.calcFactorial(factNumber));
	}
}