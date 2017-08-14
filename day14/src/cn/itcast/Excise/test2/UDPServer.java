package cn.itcast.Excise.test2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		DatagramSocket da = new DatagramSocket(8888);
		while (true) {
			byte[] bytes = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bytes, 1024);
			da.receive(dp);
			String line = new String(dp.getData());

			if ("over".equals(line.trim())) {

				System.out.println(new String(dp.getData()));
				System.out.println("·þÎñÆ÷½áÊø");

				break;
			}
			InetAddress address = dp.getAddress();
			// String hostAddress = address.getHostAddress();
			// String hostName = address.getHostName();
			byte[] data = dp.getData();
			System.out.println(address + ":" + new String(data));
		}
		da.close();

	}
}
