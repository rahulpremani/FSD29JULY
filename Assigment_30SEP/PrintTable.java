import java.util.Scanner;
class PrintTable {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of which the table you wanna print :");
		int num = scan.nextInt();

		System.out.println("Enter the limit of the table :");
		int limit = scan.nextInt();

		for(int i=1; (num*i)<=limit ;i++) {
			System.out.println(num + " * " + i +" = "+ num*i);
		}
	}
}