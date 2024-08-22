package tw.teacher.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class class43 {

	public static void main(String[] args) {
		// 把4k塞滿之後再一起output，可以縮短整個io時程
		long start = System.currentTimeMillis();
		try {
			byte[] buf =new byte[4*1024]; // buffer的容量
			
			FileInputStream fin = new FileInputStream("dir1/report.pptx");
			FileOutputStream fout = new FileOutputStream("dir2/report2.pptx"); // 複製貼上
			
			int len;
			while ((len = fin.read(buf)) != -1) {
				fout.write(len); // 讀一個輸出一個
			}
			
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("Finish");
			System.out.println(System.currentTimeMillis() - start);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
