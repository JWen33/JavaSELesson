package tw.teacher.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class class34 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("./dir1/file1.txt");
			int c;
			while ((c = fin.read()) != -1) {
				System.out.print((char)c);
			}
			
			fin.close();
			System.out.println();
			System.out.println("OK");
			FileInputStream fin2 = new FileInputStream("./dir1/file2.txt");
			System.out.println("OK2");
		} catch (FileNotFoundException e) { //要留意例外之間是否有關係，像是IOException是FileNotFoundException的父元素，所以要寫在後面(大範圍要寫最後)
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
