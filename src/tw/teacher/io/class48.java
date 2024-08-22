package tw.teacher.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class class48 {

	public static void main(String[] args) {
		try (FileReader reader = new FileReader("dir1/ns1hosp.csv"); // 僅有可自動關閉的物件，不能有其他敘述句
			 BufferedReader br = new BufferedReader(reader);) {

			// 與上方第一行相同，下面是在說明串接
//			FileInputStream fin = new FileInputStream("dir1/ns1hosp.csv");
//			InputStreamReader reader = new InputStreamReader(fin);

			String line; // readLine()回傳String所以用String+變數去接
			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				String[] data = line.split(",");
				System.out.printf("%s:%s:%s:%s\n", data[1], data[2], data[4], data[7]);
			}

			br.close();
			System.out.println("ok");

		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
