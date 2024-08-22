package tw.teacher.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import org.mindrot.BCrypt;

public class JDBC09 {
	static Connection conn; // 使用static的原因是因為沒有產出JDBC09的物件實體

	public static void main(String[] args) {
		System.out.println("Register...");
		// 連線成功才會問帳號密碼
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		String url = "jdbc:mysql://127.0.0.1:8889/winny";

		try {
			conn = DriverManager.getConnection(url, prop);

			Scanner scanner = new Scanner(System.in);

			// 輸入到帳號不重複
			String account;
			do {
				System.out.print("Account: ");
				account = scanner.next();
			} while (isAccountExist(account));

			System.out.print("Password: ");
			String password = scanner.next();
			System.out.print("Name: ");
			String name = scanner.next();

			String sql = "INSERT INTO member (account, password, name) VALUES (?, ?, ?)";
			String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, account);
			pstmt.setString(2, hashPassword);
			pstmt.setString(3, name);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Register Success");
			} else {
				System.out.println("Register Failed");
			}
		} catch (Exception e) {
			System.out.println(e); // 觀看錯誤
			throw new RuntimeException(); // 處裡例外 => 拋出例外
		}

	}

	// 檢查帳號是否重複
	static boolean isAccountExist(String account) throws SQLException { // 交給外面處理
//		String sql = "SELECT account FROM member WHERE account = ?"; // 1 . 第一種方法
		String sql = "SELECT count(account) count FROM member WHERE account = ?"; // 2 . 第二種
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt("count");
		
		

//		return rs.next(); // 1 . next有資料就是true，沒有資料就是false
		return count > 0; // 2 . 第二種
	}

}
