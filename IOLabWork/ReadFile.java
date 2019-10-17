package assignments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("temp.txt");
		if(file.exists() == false) {
			file.createNewFile();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write("Hello There \nI'm Rahul Hi Hi Hi");
		bw.close();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String readString = "";
		int count = 0;
		while((readString = br.readLine()) != null) {
			System.out.println(++count + ". " + readString);
		}
		br.close();

	}

}
