package cn.itcast.Demo.test5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class UploadThread implements Runnable{
	private Socket thisSocket;
	public UploadThread(){};
	public UploadThread(Socket thisSocket){
		this.thisSocket = thisSocket;
	}
	
	
	
	
	@Override
	public void run() {
		try {
			//通过获取客户端getInputStream获取字节输入流
			InputStream is = thisSocket.getInputStream();
			String fileName="itcast"+System.currentTimeMillis()+new Random().nextInt(100)+".jpg";
			String file = "d:"+File.separator+"work"+fileName;
			//创建流输入到硬盘
			FileOutputStream fos = new FileOutputStream(file);
			byte[] bytes = new byte[1024];
			int len;
			while((len=is.read(bytes))!=-1){
				fos.write(bytes,0,len);
			}
			System.out.println("------向客户端返回数据----");
			OutputStream os = thisSocket.getOutputStream();
			os.write("上传成功".getBytes());
			
			os.close();
			fos.close();
			is.close();
			thisSocket.close();
			
		} catch (Exception e) {
//			throw new InterruptedException("上传失败");
		}finally{
			
		}
		
			
	}


}
