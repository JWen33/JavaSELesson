package tw.teacher.UDPTCPHTTP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class class56TCPSServer2 {
	
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9999);
				Socket socket =  server.accept(); // 準備接收，如果有成功連接會產生一個socket物件實體
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
				
				String urIp = socket.getInetAddress().getHostAddress();
				System.out.println(urIp + "=>");
			
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
		
			System.out.println("Server OK");
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
