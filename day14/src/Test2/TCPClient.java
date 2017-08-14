package Test2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws Exception {

		Socket socket= new Socket("172.0.0.1",8888);
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		
		//获取数据
		FileInputStream  fis=new FileInputStream("");
		//写数据
		int len;
		byte[] bytes=new byte[1024];
		while((len=fis.read(bytes))!=-1){
			os.write(bytes,0,len);
		}
		socket.shutdownOutput();
		System.out.println("上传完毕！");
		
		
		//接收数据
		int len2;
		byte[] bytes2= new byte[1024];
		while((len2=is.read(bytes2))!=-1){
			String string = new String(bytes,0,len2);
			System.out.println(string);
		}
		System.out.println("接收完毕");
		
		
		
		
	}
}
