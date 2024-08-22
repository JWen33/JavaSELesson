package tw.teacher.UDPTCPHTTP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class class55TCPClient {
	// serverSocket 有接到accept後會產生一個新的物件實體socket
	public static void main(String[] args) {
		File source = new File("dir1/cat.jpg");
		try (	BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
				Socket client = new Socket(InetAddress.getByName("10.0.100.175"), 7777);
				BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream());) {
			
			byte[] buf = new byte[(int)source.length()];
			bin.read(buf);
			bout.write(buf);
			
			// String mesg = "肚子餓了\n還好快下課了\n";
			// bout.write(mesg.getBytes());
			
			System.out.println("Send Ok");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
