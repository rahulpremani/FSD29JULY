package assignments;

import java.io.File;
import java.util.Scanner;

public class FileExistence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String fileString = scan.nextLine();
		File file = new File(fileString);
		System.out.println("Existence : " + file.exists());
		System.out.println("Readable : " + file.canRead());
		System.out.println("Writeable : " + file.canWrite());
		System.out.println("Type of file: " +fileString.substring(fileString.indexOf("."), fileString.length()));
		scan.close();
	}

}
