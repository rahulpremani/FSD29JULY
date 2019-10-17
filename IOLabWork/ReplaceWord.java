package assignments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReplaceWord {
	public static void main(String[] args) throws IOException {
	
		File file = new File("temp.txt");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string to be replaced : ");
		String oldString = scan.nextLine();
		System.out.println("Enter the string which old string to be replaced : ");
		String newString = scan.nextLine();
		
		scan.close();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = "";
		String temp = "";
		
		while((str = br.readLine()) != null) {
			temp+=str;
		}
		
		br.close();
		
		String finalTemp = temp.replaceAll(oldString, newString);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(finalTemp);
		bw.flush();
		bw.close();
		
		BufferedReader bs = new BufferedReader(new FileReader(file));
		str = "";
		temp = "";
		while((str = bs.readLine())!=null) {
			temp+=str;
		}
		System.out.println(temp);
		bs.close();
		
	}
}