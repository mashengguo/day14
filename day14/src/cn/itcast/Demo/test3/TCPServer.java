package cn.itcast.Demo.test3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException{
		//定义serverSocket
		ServerSocket ss = new ServerSocket(8888);
		//调用accept方法
		Socket accept = ss.accept();
		//生成数据流
		OutputStream os = accept.getOutputStream();
		InputStream is = accept.getInputStream();
		//开始接收数据
		byte[] bytes = new byte[1024];
		int len;
		while((len=is.read(bytes))!=-1){
			System.out.println(new String(bytes,0,len));
		}
		os.write("接收完毕".getBytes());
		
		//结束
		os.close();
		is.close();
		accept.close();
		ss.close();
	}
}
