import java.util.Scanner;

class PallindromChecker {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String to be checked");
		String str = scan.nextLine();
		boolean flag = false;
		for(int x = 0, y = str.length()-1 ; x< (str.length()/2); x++, y--){
			if(Character.toLowerCase(str.charAt(x))!=Character.toLowerCase(str.charAt(y)))
			{
				flag = true;
				break;
			}
		}
		if(flag)
			System.out.println("The String isn't a pallindrome");
		else
			System.out.println("The String is a Pallindrome");
	}
}