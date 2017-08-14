package cn.itcast.Excise.test1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		Socket accept = ss.accept();
		InputStream is = accept.getInputStream();

		// 服务端接收数据
		int len;
		byte[] bytes = new byte[1024*64];
		while ((len = is.read(bytes)) != -1) {
			String line= new String(bytes,0,len);
			if(line.equals("over")){
				System.exit(0);
			}
			System.out.println(line);
		}
		is.close();
		ss.close();

	}
}
