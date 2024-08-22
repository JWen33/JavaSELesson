package tw.teacher.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC04 {

	public static void main(String[] args) {
		
		// 彈性大
		String url3 = "jdbc:mysql://127.0.0.1:8889/winny";  // 3306可以不用port，?隔開參數
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try(Connection conn = DriverManager.getConnection(url3, prop)) {

			String name = "Ammy";
			String tel = "651248";
			String birth = "2000-01-01";
			int id = 4;
			String sql = "UPDATE cust SET name = ?, tel = ?, birth = ? WHERE id = ?"; // ?處的變數可能會出現隱碼攻擊

			
			PreparedStatement pstmt =  conn.prepareStatement(sql); // 先做預先準備
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, birth);
			pstmt.setInt(4, id);
			
			
			pstmt.executeUpdate();
			System.out.println("OK");
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}




