import java.util.Scanner;

class PassingNumbers {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter three numbers");
		int a = Integer.parseInt(scan.next());
		int b = Integer.parseInt(scan.next());
		int c = Integer.parseInt(scan.next());

		String result= (a>=40 ? b>=40 ? c>=40 ? (a+b+c)>=125 ? "PASSING" : "FAILING" : "FAILING" : "FAILING" : "FAILING");
		System.out.println(result);

		int temp =0;
		if(a>=40) {
			temp++;
		}
		if(b>=40) {
			temp++;
		}
		if(c>=40) {
			temp++;
		}
		if(a+b+c>=125) {
			temp++;
		}
		if(temp==4) {
			System.out.println("PASSING");
		}
		else {
			System.out.println("FAILING");
		}

		
	}
}