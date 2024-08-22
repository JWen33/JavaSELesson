package tw.teacher.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC16 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:8889/winny";
	private static final String SQL_QUERY = "SELECT * FROM gift";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // 
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s：%s\n", id, name);
			}
			// 以下是各種測試
			System.out.println("-----");
			if (rs.first()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s：%s\n", id, name);				
			}
			System.out.println("-----");
			if (rs.absolute(47)) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s：%s\n", id, name);								
			}			
			System.out.println("---修改--");
			// 直接更新不用再下sql的語法去更新
			rs.updateString("name", "古意禮"); // 針對name、town欄位進行修改
			rs.updateString("town", "田頭鎮");
			rs.updateRow(); // 整列更新
			String id = rs.getString("id");
			String name = rs.getString("name");
			System.out.printf("%s：%s\n", id, name);								
			
			System.out.println("---刪除--");
			
//			rs.deleteRow(); // 47被刪除，游標往前一個到46
			id = rs.getString("id");
			name = rs.getString("name");
			System.out.printf("%s：%s\n", id, name);								
			
			System.out.println("---新增到表格最後面--");
			rs.moveToInsertRow();
			rs.updateString("name", "古意禮"); 
			rs.updateString("feature", ""); 
			rs.updateString("addr", ""); 
			rs.updateString("picurl", ""); 
			rs.updateString("city", "");
			rs.updateString("town", "田頭鎮");
			rs.updateDouble("lat", 0.0);
			rs.updateDouble("lng", 0.0);
			rs.insertRow();

			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
