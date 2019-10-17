package assignments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyDataThread extends Thread {

	BufferedReader br;
	BufferedWriter bw;

	CopyDataThread(FileReader source, FileWriter target) {
		this.br = new BufferedReader(source);
		this.bw = new BufferedWriter(target);
	}

	public void run() {

		int ch = 0;
		int offset = 0;
		try {
			while ((ch= br.read()) != -1) {
				offset++;
				bw.write((char)ch);
				if(offset == 10) {
					System.out.println("10 Characters are copied");
					offset = 0;
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
