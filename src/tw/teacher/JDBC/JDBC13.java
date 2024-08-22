package tw.teacher.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.swing.text.Position.Bias;

import tw.teacher.apis.Bike;

public class JDBC13 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:8889/winny";
	private static final String SQL_UPDATE = "UPDATE member SET bike = ? WHERE id = ?"; // 物件要先序列化才可以
	
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		
		Bike b1 = new Bike();
		b1.upSpeed(); b1.upSpeed(); b1.upSpeed(); b1.upSpeed(); b1.upSpeed(); b1.upSpeed(); 
		System.out.println(b1.getSpeed());

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setObject(1, b1);
			pstmt.setInt(2, 1);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("UPDATE OK");
			} else {
				System.out.println("UPDATE FAILURE");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
