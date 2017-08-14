package cn.itcast.Demo.test5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
	public static void main(String[] args) throws IOException{
		ServerSocket sp = new ServerSocket(8888);
		while(true){
		Socket thisSocket = sp.accept();
		new Thread(new UploadThread(thisSocket)).start();
		}

	}
}
