package Test1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		//定义接收端
		DatagramSocket ds= new DatagramSocket(8888);
		//定义接收包
		while(true){
			byte[] bytes= new byte[1024*64];
			DatagramPacket dp = new DatagramPacket(bytes,1024*64);
			ds.receive(dp);
			//拆包
			int length = dp.getLength();
			byte[] data = dp.getData();
			String str = new String(data);
			System.out.println(str);
			System.out.println("好的");
			//判断是否为over
			if("over".equals(str)){
				System.out.println("接收完毕！");
				break;
			}
			
		}
		
	}
}
