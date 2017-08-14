package Excise.Test2;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss= new ServerSocket(8888);
		Socket socket = ss.accept();
		OutputStream os = socket.getOutputStream();
		FileInputStream fis=new FileInputStream("D:\\work\\a.jpeg");
		byte[] bytes= new byte[1024];
		int len;
		while((len= fis.read(bytes))!=-1){
			os.write(bytes,0,len);
		}
//		socket.shutdownOutput();
		System.out.println("Êä³ö½áÊø");
		fis.close();
		ss.close();
	}
}
