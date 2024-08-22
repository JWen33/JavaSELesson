package tw.teacher.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC02 {

	public static void main(String[] args) {
		// 彈性大
		String url3 = "jdbc:mysql://127.0.0.1:8889/winny";  // 3306可以不用port，?隔開參數
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try(Connection conn = DriverManager.getConnection(url3, prop)) {

			Statement stmt = conn.createStatement();
			String sql = "UPDATE cust SET tel = '65487000' WHERE id = '3'";
			
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}




