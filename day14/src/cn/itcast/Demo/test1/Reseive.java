package cn.itcast.Demo.test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Reseive {
	public static void main(String[] args) throws IOException {
		//定义接收端口
		DatagramSocket ds = new DatagramSocket(9527);
		//定义接收包对此昂
		byte[] bytes = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bytes,1024);
		
		
		
		while(true){
			ds.receive(dp);
			//获取数据，ip，name
			InetAddress address = dp.getAddress();
			String hostAddress = address.getHostAddress();
			String hostName = address.getHostName();
			
			//获取数据包
			byte[] data = dp.getData();
			int length = dp.getLength();
			String stringData= new String(data,0,length);
			//显示接收的数据
			System.out.println(hostAddress+"\t"+hostName+"\t"+stringData);
//			ds.close();
		}
	}
}
