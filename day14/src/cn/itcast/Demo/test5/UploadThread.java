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
			//ͨ����ȡ�ͻ���getInputStream��ȡ�ֽ�������
			InputStream is = thisSocket.getInputStream();
			String fileName="itcast"+System.currentTimeMillis()+new Random().nextInt(100)+".jpg";
			String file = "d:"+File.separator+"work"+fileName;
			//���������뵽Ӳ��
			FileOutputStream fos = new FileOutputStream(file);
			byte[] bytes = new byte[1024];
			int len;
			while((len=is.read(bytes))!=-1){
				fos.write(bytes,0,len);
			}
			System.out.println("------��ͻ��˷�������----");
			OutputStream os = thisSocket.getOutputStream();
			os.write("�ϴ��ɹ�".getBytes());
			
			os.close();
			fos.close();
			is.close();
			thisSocket.close();
			
		} catch (Exception e) {
//			throw new InterruptedException("�ϴ�ʧ��");
		}finally{
			
		}
		
			
	}


}
