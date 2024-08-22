package tw.teacher.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GiftDB {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:8889/winny";
	private static final String SQL_QUERY = "SELECT * FROM gift";

	private Connection conn;
	private ResultSet rs;
	private String[] fileds; 

	public GiftDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);

		conn = DriverManager.getConnection(URL, prop);
	}

	public void query() throws SQLException {
		query(SQL_QUERY);
	}

	public void query(String sql) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql); // 初始化ResultSet rs
		ResultSetMetaData rsmd =  rs.getMetaData();
		fileds = new String[rsmd.getColumnCount()]; //初始化
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			fileds[i] = rsmd.getColumnLabel(i + 1);
			System.out.println(fileds[i]);
		}
	}

	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			return 0; // 沒有row 回傳0
		}
		
	}

	public int getCols() {
		return fileds.length; // fileds是陣列使用length
	}

	public String getData(int row, int col) {
		try {
			rs.absolute(row + 1);			
			return rs.getString(fileds[col]); // col剛好也是zero base
		} catch (Exception e) {
			return "error";
		}
	}
	
	public String[] getFiledName() {
		return fileds; // 如果要換名稱，可以從select的時候直接as，或是一個個指定
	}
	
	public void delData(int row) throws SQLException {
		rs.absolute(row + 1);
		rs.deleteRow();
	}
	
	public void updateData(String newdata, int row, int col) {
		try {
			rs.absolute(row + 1);
			rs.updateString(col + 1, newdata);
			rs.updateRow();
		} catch (SQLException e) {
			System.out.println(e);
		} 
	}
}

