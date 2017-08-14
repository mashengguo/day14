package cn.itcast.Demo.test4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
	public static void main(String[] args) throws IOException{
		ServerSocket ss= new ServerSocket(8888);
		Socket accept = ss.accept();
		OutputStream os = accept.getOutputStream();
		InputStream is = accept.getInputStream();
		
		
	FileOutputStream fos = new FileOutputStream("d:\\work\\a.jpeg");	
		
		int len;
		byte[] bytes= new byte[1024];
		while((len=is.read(bytes))!=-1){
			fos.write(bytes,0,len);
		}
		System.out.println("接收完毕！");
		os.write("服务器已经接收完毕".getBytes());
		
		
		os.close();
		is.close();
		fos.close();
		ss.close();
	}
}
