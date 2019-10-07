import java.util.Scanner;

class BinaryEquiv {

	static void binaryEquivalent(int num,int rem) {

		if(num==0)
			return;

		rem = num % 2;
		binaryEquivalent(num/2,0);
		System.out.print(rem);
	}
	public static void main(String[] args) {
		
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter the Number");
		int num = scan.nextInt();
		int rem=0;

		BinaryEquiv.binaryEquivalent(num,rem);

	}
}