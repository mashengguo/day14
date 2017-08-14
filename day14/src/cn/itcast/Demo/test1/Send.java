package cn.itcast.Demo.test1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class Send {
	public static void main(String[] args) throws IOException{
		//定义socket端口
		DatagramSocket ds = new DatagramSocket();
		//定义packet包对象
		Scanner sc= new Scanner(System.in);
		while(true){
			String nextLine = sc.nextLine();
			byte[] bytes =nextLine.getBytes();
			DatagramPacket dp = new DatagramPacket(bytes,bytes.length,InetAddress.getByName("192.168.91.45"),8888);
			ds.send(dp);
		}
	}
 }
