package Test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) throws IOException{
		//����UDP���Ͷ�
		DatagramSocket ds = new DatagramSocket();
		Scanner sc = new Scanner(System.in);
		while(true){
			// ����¼������
			System.out.println("�����룺");
			String line = sc.nextLine();
			//�����
			byte[] bytes =line.getBytes();
			DatagramPacket dp =new DatagramPacket(bytes,bytes.length,InetAddress.getByName("127.0.0.1"),8888);
			//��������
			ds.send(dp);
			if("over".equals(line)){
				//��Ϣ����
				System.out.println("�������");
				break;
			}
		}
		
		
	}
}
