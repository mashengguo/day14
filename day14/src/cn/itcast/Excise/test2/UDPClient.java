package cn.itcast.Excise.test2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("请输入信息：");
			String line = sc.nextLine();
			byte[] bytes =line.getBytes();
			DatagramPacket dp = new DatagramPacket(bytes,bytes.length,InetAddress.getByName("127.0.0.1"),8888);
			ds.send(dp);
			if(line.equals("over")){
				System.out.println("结束！");
				break;
			}
		}
		sc.close();
		ds.close();
		
	}
}
