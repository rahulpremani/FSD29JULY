import java.util.Scanner;

class FullNameException extends Exception{
	
	public String getMessage() {
		return "Name couldn't be empty";
	}
}

class ValidateFullName {
	public static void main(String[] args) throws FullNameException{
			
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Name :");
		String fullName = scan.nextLine();
		if(fullName.length()==0)
		{
			throw new FullNameException();
		}
		else {
			System.out.println("Your Name is :" + fullName);
		}
	}
}