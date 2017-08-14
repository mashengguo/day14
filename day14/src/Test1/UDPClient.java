package Test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) throws IOException{
		//定义UDP发送端
		DatagramSocket ds = new DatagramSocket();
		Scanner sc = new Scanner(System.in);
		while(true){
			// 键盘录入数据
			System.out.println("请输入：");
			String line = sc.nextLine();
			//定义包
			byte[] bytes =line.getBytes();
			DatagramPacket dp =new DatagramPacket(bytes,bytes.length,InetAddress.getByName("127.0.0.1"),8888);
			//发送数据
			ds.send(dp);
			if("over".equals(line)){
				//信息提醒
				System.out.println("发送完毕");
				break;
			}
		}
		
		
	}
}
