package Test1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		//������ն�
		DatagramSocket ds= new DatagramSocket(8888);
		//������հ�
		while(true){
			byte[] bytes= new byte[1024*64];
			DatagramPacket dp = new DatagramPacket(bytes,1024*64);
			ds.receive(dp);
			//���
			int length = dp.getLength();
			byte[] data = dp.getData();
			String str = new String(data);
			System.out.println(str);
			System.out.println("�õ�");
			//�ж��Ƿ�Ϊover
			if("over".equals(str)){
				System.out.println("������ϣ�");
				break;
			}
			
		}
		
	}
}
