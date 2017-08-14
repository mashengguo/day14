package Excise.Test2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException {
		Socket  s=new Socket("127.0.0.1",8888);
		InputStream is = s.getInputStream();
		FileOutputStream fos= new FileOutputStream("d:\\work\\d.jpeg");
		
		
		int len;
		byte[] bytes=new byte[1024];
		while((len= is.read(bytes))!=-1){
			fos.write(bytes,0,len);
		}
		System.out.println("Ω” ’ÕÍ±œ£°");
		fos.close();
		s.close();
		
	}
}
