package tw.teacher.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import org.mindrot.BCrypt;

public class JDBC10 {
	static Connection conn;

	public static void main(String[] args) {
		System.out.println("Login...");

		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		String url = "jdbc:mysql://127.0.0.1:8889/winny";

		try {
			conn = DriverManager.getConnection(url, prop);

			Scanner scanner = new Scanner(System.in);

			System.out.print("Account: ");
			String account = scanner.next();
			System.out.print("Password: ");
			String password = scanner.next();
			
			
			String sql = "SELECT * FROM member WHERE account = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // 確認是唯一的帳號後
				String hasPassword = rs.getString("password");
				if (BCrypt.checkpw(password, hasPassword)) {
					System.out.println("Login Success");
					System.out.printf("Welcome, %s", rs.getString("name"));
				} else {
					System.out.println("Login Failure(1)");					
				}
			} else {
				System.out.println("Login Failure(2)");					
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
