package tw.teacher.UDPTCPHTTP;

import java.io.StreamCorruptedException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class class54UDPReceive {

	public static void main(String[] args) {
		byte[] buf = new byte[4*1024]; // 自行決定大小
		try {
			DatagramSocket socket = new DatagramSocket(8888);
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
//			System.out.println("before");
			socket.receive(packet); // 會一直開啟在這等封包
//			System.out.println("After");
			socket.close();
			
			String urIp = packet.getAddress().getHostAddress();
			byte[] data = packet.getData();
			int len = packet.getLength(); // 這個資訊很重要
			System.out.println("Receive OK");
			System.out.printf("%s => %s\n", urIp, new String(data, 0, len));
			System.out.println(data.length); 
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
