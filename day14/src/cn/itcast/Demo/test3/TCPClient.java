package cn.itcast.Demo.test3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException{
		//定义客户端对象绑定服务器地址和端口地址
		Socket s= new Socket("127.0.0.1",8888);
		//获取输入输出字节流
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		
		os.write("我是马胜国".getBytes());
		//告诉服务器 我写完了 你可以不用等了
				s.shutdownOutput();
		System.out.println("------这是客户端发送的数据-----");
		
		byte[] bytes = new byte[1024];
		int len;
		while((len=is.read(bytes))!=-1){
			String line = new String(bytes,0,len);
			System.out.println(line);
		}
		System.out.println("接收服务器数据完毕");
		
		//关闭资源
		os.close();
		is.close();
		s.close();
		
	}
}
