import java.util.Scanner;
class ReverseString {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string to be reversed");
		String str = scan.nextLine();
		char[] ch = str.toCharArray();

		for(int x = 0, y = ch.length-1; x < (ch.length/2); x++, y--) {
			
			char temp = ch[x];
			ch[x]= ch[y];
			ch[y]=temp;
		}	
		System.out.println("Your Original string : " + str);
		System.out.println("Your reversed String : " + String.valueOf(ch));
	}
}