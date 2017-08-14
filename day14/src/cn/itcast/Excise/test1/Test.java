package cn.itcast.Excise.test1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
public static void main(String[] args) throws IOException {
	InetAddress host = InetAddress.getLocalHost();
	System.out.println(host);
	System.out.println(host.toString());
	System.out.println(host.getHostName());
	System.out.println(host.getHostAddress());
	
}
}
