package tw.teacher.UDPTCPHTTP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class class56TCPSServer {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(7777); Socket socket = server.accept();) // 準備接收，如果有成功連接會產生一個socket物件實體)
		{

			String urIp = socket.getInetAddress().getHostAddress();
			System.out.println(urIp + "=>");

			String fname = String.format("di2/%s.jpg", urIp);
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fname)); // buffer
																								// output到server的packet

			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream()); // 接收近來到buffer，接到server端，利用buffer效能可以更好
			byte[] buf = new byte[4 * 1024];
			int len;
			while ((len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}

			bout.flush();
			bout.close();

			System.out.println("Server OK");
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
