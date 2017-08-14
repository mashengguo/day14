package cn.itcast.Demo.test4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadClient {
	public static void main(String[] args) throws IOException{
		Socket s = new Socket("127.0.0.1",8888);
		OutputStream os = s.getOutputStream();
		InputStream in= s.getInputStream();
		
		
		//定义一个输出流
//		FileOutputStream fos = new FileOutputStream("");
		//定义一个输入流
		FileInputStream fis = new FileInputStream("d:\\work\\9beb89f8841111f4c0415d3cc54ec704.jpg");
		
		//输出
		int len;
		byte[] bytes = new byte[1024];
		while((len=fis.read(bytes))!=-1){
			os.write(bytes,0,len);
		}
		s.shutdownOutput();
		System.out.println("传输完毕");
		
		
		int len2;
		byte[] bytes2 = new byte[1024];
		while((len2=in.read(bytes2))!=-1){
			String line= new String(bytes2,0,len2);
			System.out.println(line);
		}
		
		//关闭资源
		os.close();
		in.close();
		fis.close();
//		fos.close();
		s.close();
		
	}
}
