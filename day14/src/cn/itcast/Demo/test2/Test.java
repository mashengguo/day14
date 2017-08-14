package cn.itcast.Demo.test2;

import java.io.IOException;
import java.net.InetAddress;

public class Test {
	public static void main(String[] args) throws IOException {
		InetAddress host = InetAddress.getLocalHost();
		System.out.println(host);
		InetAddress name = InetAddress.getByName("peter-PC");
		System.out.println(name);

		String hostName = host.getHostName();
		System.out.println(hostName);
		String hostAddress = host.getHostAddress();
		System.out.println(hostAddress);
	}
}
