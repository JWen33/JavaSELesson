package tw.teacher.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class class41 {

	public static void main(String[] args) {
		try {
			File source = new File("./dir1/file2.txt");
			FileInputStream fin = new FileInputStream(source);
			
			// 2G以下檔案
			int len; byte[] buf = new byte[(int)source.length()];
//			len = fin.read(buf);
//			System.out.println(new String(buf, 0, len));
			
//			while ((len = fin.read(buf)) != -1) {
//				System.out.print(new String(buf, 0, len));
//			}
			
			fin.read(buf);
			System.out.println(new String(buf));
			
			fin.close();
			System.out.println();
			System.out.println("OK");

		} catch (FileNotFoundException e) { //要留意例外之間是否有關係，像是IOException是FileNotFoundException的父元素，所以要寫在後面(大範圍要寫最後)
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
