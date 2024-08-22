package tw.teacher.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC05 {

	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Name: ");
			String name = scanner.next();
			System.out.print("Tel: ");
			String tel = scanner.next();
			System.out.print("Birthday: ");
			String birth = scanner.next();
			
			String url = "jdbc:mysql://127.0.0.1:8889/winny";
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			
			try(Connection conn = DriverManager.getConnection(url, prop)){
				String sql = "INSERT INTO cust (name,tel,birth) VALUES (?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, tel);
				pstmt.setString(3, birth);
				if (pstmt.executeUpdate() > 0) {
					System.out.println("Inser Success");
				}else {
					System.out.println("xxxx");
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}

}




