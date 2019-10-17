package assignments1;

import java.util.Scanner;

public class ValidateUserName {
	
	static boolean UserNameValidator(String str) {
		if(str.endsWith("_job") && str.length()>=12) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the UserName, it should be having atleast 12 chars and should end with _job : ");
		
		System.out.println(ValidateUserName.UserNameValidator(scan.nextLine()));
		
		scan.close();
	}

}
