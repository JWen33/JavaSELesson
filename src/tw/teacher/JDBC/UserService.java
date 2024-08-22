package tw.teacher.JDBC;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UserService {
	
	
    public static void registerUser(String username, String password) throws SQLException, NoSuchAlgorithmException {
    	String url3 = "jdbc:mysql://127.0.0.1:8889/users";  // 3306可以不用port，?隔開參數
    	Properties prop = new Properties();
    	prop.put("user", "root");
    	prop.put("password", "root");
        try (Connection conn = DriverManager.getConnection(url3, prop)) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, hashPassword(password));
                stmt.executeUpdate();
            }
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
