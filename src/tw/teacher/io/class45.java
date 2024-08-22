package tw.teacher.io;

import java.io.FileReader;
//import java.io.*; // *指相同package的全部物件

public class class45 {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("./dir1/file2.txt");
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char)c); // 使用print不換行
			}
			fr.close();
			System.out.println("OK");
		} catch (Exception e){
			System.out.println(e);
		}

	}

}
