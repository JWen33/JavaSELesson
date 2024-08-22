package tw.teacher.UDPTCPHTTP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class class59HTTP3 {

	public static void main(String[] args) {

		try {
			FileOutputStream fout = new FileOutputStream("dir2/google.jpg");
			
			URL url = new URL("https://s.yimg.com/ny/api/res/1.2/rNPFiilGxMc4jZ4vYmj1Lg--/YXBwaWQ9aGlnaGxhbmRlcjt3PTk2MDtoPTY0MTtjZj13ZWJw/https://s.yimg.com/os/creatr-uploaded-images/2024-08/0b03dd70-582d-11ef-a49b-305ba22355b1"); // 意思指日後的版本可能會禁用
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
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
