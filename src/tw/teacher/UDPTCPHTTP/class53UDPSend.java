package tw.teacher.UDPTCPHTTP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class class53UDPSend {

	public static void main(String[] args) {
		try {
			String mesg = "星期五了!";
			byte[] mesgbuf = mesg.getBytes();
			// 目前是UDP
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(mesgbuf, mesgbuf.length, InetAddress.getByName("10.0.100.113"), 8888);
			
			socket.send(packet);
			socket.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

		
		// TCP連結：效率差，進行三方交握ECK，確認是目標確認以連接，資料傳遞完整性，目前大部分通訊協定都是TCP
		// UDP非連接：效率好，資料有遺失的可能，ex遊戲人物突然lag跳一格
		// 一個ip有2^16個port，0~65535，1024以前有特殊用途通常通常不會拿來用，ex：80 => WWW，這個重要吧！就是全球資訊網伺服器，
																	//443 => https，有安全加密機制的WWW伺服器
		// 發送端從哪個port沒有差，也可以指定，封包會有ip、port
		// 一個電腦可以有多個ip，但一個裝置只會有一個ip

	}

}
