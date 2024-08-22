package tw.teacher.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {

	public static void main(String[] args) {
		// Load Driver (connector)
		// But, 這裡使用library，就不用自己寫code載入，但也只限這
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 名稱要對才能載入，也一同載入mysql API，但只限於mySQL使用，所以使用java.sql的API來實做練習
			System.out.println("OK 已載入");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
		
//		String url1 = "jdbc:mysql://127.0.0.1:8889/winny?user=root&password=root";  // 127.0.0.1也可以用別名localhost，3306可以不用port，?隔開參數
//		try(Connection conn = DriverManager.getConnection(url1)) {
//			System.out.println("OK已連線到資料庫");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
//		String url2 = "jdbc:mysql://127.0.0.1:8889/winny";  // 3306可以不用port，?隔開參數
//		try(Connection conn = DriverManager.getConnection(url2, "root", "root")) {
//			System.out.println("OK2已連線到資料庫");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		
		// 彈性大
		String url3 = "jdbc:mysql://127.0.0.1:8889/winny";  // 3306可以不用port，?隔開參數
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try(Connection conn = DriverManager.getConnection(url3, prop)) {
//			System.out.println("OK3已連線到資料庫");
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO cust (name, tel, birth) VALUES ('Brad', '123456', '1999-01-02')";
			sql += ", ('Winny', '654321', '1995-10-05')";
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}




