package tw.teacher.UDPTCPHTTP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class class57HTTP {
	// 寫server從這裡開始，透過TCP不斷與cilent對話
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(80); Socket socket = server.accept();) // 準備接收，如果有成功連接會產生一個socket物件實體)

		{
			System.out.println("OK");

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
