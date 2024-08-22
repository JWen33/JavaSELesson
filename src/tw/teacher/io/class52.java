package tw.teacher.io;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class class52 {

	public static void main(String[] args) {
		try {
			// 沒有物件實體，所以使用與物件無關的static方法
			InetAddress ip = InetAddress.getByName("www.google.com.tw"); // 空白 => 本機迴路ip，localhost只是別名(可以隨意取)；=>140.(教育開頭)
													    // 寫主機名稱(ex網址)會委託DNS去查ip再回傳回來
														// 	寫ip合理(55.255.255.255內)的話就都可以都認識不會拋出例外
			System.out.println(ip);
		} catch (UnknownHostException e) {
			System.out.println(e);			
		} 
	}

}

