package cn.itcast.Demo.test3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException{
		//����ͻ��˶���󶨷�������ַ�Ͷ˿ڵ�ַ
		Socket s= new Socket("127.0.0.1",8888);
		//��ȡ��������ֽ���
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		
		os.write("������ʤ��".getBytes());
		//���߷����� ��д���� ����Բ��õ���
				s.shutdownOutput();
		System.out.println("------���ǿͻ��˷��͵�����-----");
		
		byte[] bytes = new byte[1024];
		int len;
		while((len=is.read(bytes))!=-1){
			String line = new String(bytes,0,len);
			System.out.println(line);
		}
		System.out.println("���շ������������");
		
		//�ر���Դ
		os.close();
		is.close();
		s.close();
		
	}
}
