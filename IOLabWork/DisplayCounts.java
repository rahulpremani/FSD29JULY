package assignments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DisplayCounts {

	public static void main(String[] args) throws IOException {
		
		File file = new File("temp.txt");
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String str = "";
		while((str = br.readLine()) != null) {
			sb.append(str);
		}
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.toString().split("\n").length+1);
		System.out.println(sb.toString().split(" ").length);
		br.close();

	}

}
