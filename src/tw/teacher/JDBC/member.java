package tw.teacher.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class member {

	public static void main(String[] args) {
		String url3 = "jdbc:mysql://127.0.0.1:8889/users";  // 3306可以不用port，?隔開參數
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try(Connection conn = DriverManager.getConnection(url3, prop)) {

			Statement stmt = conn.createStatement();
			String sql = "CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) NOT NULL UNIQUE, password VARCHAR(50) NOT NULL)";
			
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}


