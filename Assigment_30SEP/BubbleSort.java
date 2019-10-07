import java.util.Scanner;

class BubbleSort {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] temp = new int[5];

		System.out.println("Enter 5 numbers ");
		for (int i = 0 ; i < temp.length ; i++ ) {
			temp[i] = scan.nextInt();
		}
		for(int a = temp.length-1 ; a > 0; a--) {
			for (int b = 0; b < a-1 ; b++ ) {
				if(temp[b] > temp[b+1]) {
					int nat= temp[b];
					temp[b]=temp[b+1];
					temp[b+1]=nat;
				}
			}
		}

		for(int x : temp) {
			System.out.println(x);
		}
	}
}