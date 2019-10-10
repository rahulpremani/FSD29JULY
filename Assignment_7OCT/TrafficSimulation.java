import java.util.Scanner;

class TrafficSimulation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Select one");
		System.out.println("1. Red");
		System.out.println("2. Yellow");
		System.out.println("3. Green");

		int option = scan.nextInt();

		switch(option) {
			case 1:
				System.out.println("Stop");
				break;
			case 2:
				System.out.println("Ready");
				break;
			case 3:
				System.out.println("Go");
				break;
			default:
				System.out.println("Sorry..wrong option");
				break;
		}	
	}
}