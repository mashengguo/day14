package cn.itcast.Demo.test3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException{
		//����serverSocket
		ServerSocket ss = new ServerSocket(8888);
		//����accept����
		Socket accept = ss.accept();
		//����������
		OutputStream os = accept.getOutputStream();
		InputStream is = accept.getInputStream();
		//��ʼ��������
		byte[] bytes = new byte[1024];
		int len;
		while((len=is.read(bytes))!=-1){
			System.out.println(new String(bytes,0,len));
		}
		os.write("�������".getBytes());
		
		//����
		os.close();
		is.close();
		accept.close();
		ss.close();
	}
}
