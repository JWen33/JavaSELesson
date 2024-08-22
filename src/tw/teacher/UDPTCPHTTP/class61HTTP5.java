package tw.teacher.UDPTCPHTTP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class class61HTTP5 {

	public static void main(String[] args) {

		try { // 從open source抓資料
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx"); // 意思指日後的版本可能會禁用
			URLConnection conn = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(bin));

			String line;
			StringBuffer sb = new StringBuffer(); // JSON要全部讀完才可以解析，JSON中換行符號沒有意義且浪費網路資源
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			// 以上是抓到JSON資料
			bin.close();
			
			// 將JSON變成文字檔
			parseJSON(sb.toString());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// 進行解析，格式是陣列[{物件}, {物件}, {物件}....]，大部粉是物件
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
//		JSONObject r = new JSONObject();
		System.out.println(root.length());

		String url = "jdbc:mysql://127.0.0.1:8889/winny";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		try {
			
			Connection conn = DriverManager.getConnection(url, prop);
			
			
			Statement stmt = conn.createStatement(); //下指令用
			stmt.executeUpdate("DELETE FROM gift"); // 新增前刪除全部
			stmt.executeUpdate("ALTER TABLE gift AUTO_INCREMENT = 1"); // 自動編號又從212開始，所以要重新設定屬性
			
			
			String sql = "INSERT INTO gift (name, feature, addr, picurl, city, town, lat, lng)"
					+ " VALUES (?, ?, ?, ?, ?, ?,?, ?)";
			PreparedStatement pstmt =  conn.prepareStatement(sql);
			
			
			for (int i = 0; i < root.length(); i++) {
				JSONObject element = root.getJSONObject(i);
				String name = element.getString("Name");
				String feature = element.getString("Feature");
				String addr = element.getString("SalePlace");
				String picurl = element.getString("Column1");
				String city = element.getString("County");
				String town = element.getString("Township");
				String lat = element.getString("Latitude");
				String lng = element.getString("Longitude");
				
				pstmt.setString(1, name);
				pstmt.setString(2, feature);
				pstmt.setString(3, addr);
				pstmt.setString(4, picurl);
				pstmt.setString(5, city);
				pstmt.setString(6, town);
				
				try { // 因為有些經緯度是空的，所以要拋出例外，直接將值加上0，如果沒有在迴圈中使用，會導致拋出例外 => 所有的資料無法匯入
					pstmt.setDouble(7, Double.parseDouble(lat));
					pstmt.setDouble(8, Double.parseDouble(lng));
				} catch(Exception e) {
					pstmt.setDouble(7, 0);
					pstmt.setDouble(8, 0);
				}
				
				
				
				pstmt.executeUpdate();
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
