package cn.itcast.Demo.test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Reseive {
	public static void main(String[] args) throws IOException {
		//������ն˿�
		DatagramSocket ds = new DatagramSocket(9527);
		//������հ��Դ˰�
		byte[] bytes = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bytes,1024);
		
		
		
		while(true){
			ds.receive(dp);
			//��ȡ���ݣ�ip��name
			InetAddress address = dp.getAddress();
			String hostAddress = address.getHostAddress();
			String hostName = address.getHostName();
			
			//��ȡ���ݰ�
			byte[] data = dp.getData();
			int length = dp.getLength();
			String stringData= new String(data,0,length);
			//��ʾ���յ�����
			System.out.println(hostAddress+"\t"+hostName+"\t"+stringData);
//			ds.close();
		}
	}
}
