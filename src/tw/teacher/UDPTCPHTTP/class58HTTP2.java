package tw.teacher.UDPTCPHTTP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class class58HTTP2 {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://www.google.com.tw"); // 意思指日後的版本可能會禁用
			URLConnection conn = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(bin));
			
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			// 會讀出頁面原始碼
			bin.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
