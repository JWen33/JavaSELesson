package tw.teacher.JDBC;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.teacher.apis.Bike;

public class JDBC14 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:8889/winny";
	private static final String SQL_QUERY = "SELECT * FROM member WHERE id = ?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				InputStream in = rs.getBinaryStream("bike");
				// -------
				ObjectInputStream oin = new ObjectInputStream(in); // 將取的資料序列化後讀取
				Object obj = oin.readObject(); // 原本回傳是物件類別
				Bike b1 = (Bike) obj; // 要轉換成Bike之後
				System.out.println(b1.getSpeed()); // 才能使用Bike的方法 => getSpeed()

				// 確認傳回的是Bike
//				if (obj instanceof Bike) {
//					System.out.println("Yes");
//				} else {
//					System.out.println("No");
//				}

			} else {
				System.out.println("id is not exist");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
