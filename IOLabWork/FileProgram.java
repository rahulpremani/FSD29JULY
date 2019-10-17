package assignments;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import assignments.CopyDataThread;

public class FileProgram {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File source = new File("source.txt");
		File target = new File("target.txt");
		if(source.exists() == false) {
			try {
				source.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(target.exists() == false) {
			try {
				target.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		CopyDataThread cdt = new CopyDataThread(new FileReader(source),new FileWriter(target));
		cdt.start();
	}

}
