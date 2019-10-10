import java.util.Scanner;

class AgeException extends RuntimeException {
	AgeException() {
		System.out.println("Your age should be above 15");
	}
}

class ValidateAge {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your age");
		int age = scan.nextInt();
		if(age<15) {
			throw new AgeException();
		}
		else {
			System.out.println("Your age is : " + age);
		}
	}
}