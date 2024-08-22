package tw.teacher.UDPTCPHTTP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class class60HTTP4 {

	public static void main(String[] args) {

		try {
			FileOutputStream fout = new FileOutputStream("dir2/gamer.pdf");
			// 刪除線意思指日後的版本可能會禁用
			URL url = new URL("https://pdfmyurl.com/?url=https://www.gamer.com.tw"); // 後端有兩種接收 get post
			URLConnection conn = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			
		
			byte[] buf = new byte[4*1024];
			int len;
			while ((len = bin.read(buf)) != -1) {
				fout.write(buf, 0, len); // 從頭讀到尾一次讀完
			}
			
			// 會讀出頁面原始碼
			bin.close();
			
			fout.flush();
			fout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
