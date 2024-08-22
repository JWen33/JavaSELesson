package tw.teacher.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc06 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String url = "jdbc:mysql://127.0.0.1:8889/winny";
		
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			String sql = "SELECT * FROM gift ORDER BY city";
			Statement stmt =  conn.createStatement(); // 產生sql敘述句
			ResultSet rs = stmt.executeQuery(sql); // return resultSet
			
			// 遂意移動游標的行為都會降低效能，與拋出例外，後續會進行設定來解決
//			System.out.println(rs.getRow()); // 回傳0，所以在第一列的前面
//			rs.next();
////			System.out.println(rs.getRow()); // 回傳1
////			rs.first();
////			System.out.println(rs.getRow()); // java.sql.SQLException: Operation not allowed for a result set of type ResultSet.TYPE_FORWARD_ONLY.
//			int id = rs.getInt("id"); // 原本是填1，改使用欄位名稱來查詢會更好維護
//			System.out.println(id); 
//			String name =  rs.getString("name");
//			System.out.println(name);
			
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				
				System.out.printf("%s：%s：%s\n", id, name, city);
			}
			
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		

	}

}
